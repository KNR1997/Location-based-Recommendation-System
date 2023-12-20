package Locationbased.Recommendation.System.Neo4j.service.UserService;

import Locationbased.Recommendation.System.Neo4j.algorithm.ContentBasedFiltering;
import Locationbased.Recommendation.System.Neo4j.algorithm.RecommendedPlaces;
import Locationbased.Recommendation.System.Neo4j.config.AuthenticatedUserUtil;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserLikedNotLikedSubCategoryDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserRecordDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserSubCategoryDTO;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.models.node.UserRecordNode;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikeSubCategoryQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikedFieldsResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserRatePlaceQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.DistrictRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.SubCategoryRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserRecordNodeRepository;
import Locationbased.Recommendation.System.Neo4j.requests.CreateUserRequest;
import Locationbased.Recommendation.System.Neo4j.service.async.FindUserRecommendedPlaces;
import Locationbased.Recommendation.System.Neo4j.service.context.UserRecommendedPlacesContext;
import Locationbased.Recommendation.System.Neo4j.service.generate.UserRecommendedPlacesGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserNodeRepository userNodeRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRecommendedPlacesGenerator userRecommendedPlacesGenerator;
    private final UserProcess userProcess;
    private final SubCategoryRepository subCategoryRepository;
    private final ContentBasedFiltering contentBasedFiltering;
    private final RecommendedPlaces recommendedPlaces;
    private final FindUserRecommendedPlaces findUserRecommendedPlaces;
    private final DistrictRepository districtRepository;
    private final UserRecordNodeRepository userRecordNodeRepository;

    public UserService(UserNodeRepository userNodeRepository,
                       PasswordEncoder passwordEncoder,
                       UserRecommendedPlacesGenerator userRecommendedPlacesGenerator,
                       UserProcess userProcess,
                       SubCategoryRepository subCategoryRepository,
                       RecommendedPlaces recommendedPlaces,
                       ContentBasedFiltering contentBasedFiltering,
                       FindUserRecommendedPlaces findUserRecommendedPlaces,
                       DistrictRepository districtRepository,
                       UserRecordNodeRepository userRecordNodeRepository
    ) {
        this.userNodeRepository = userNodeRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRecommendedPlacesGenerator = userRecommendedPlacesGenerator;
        this.userProcess = userProcess;
        this.subCategoryRepository = subCategoryRepository;
        this.recommendedPlaces = recommendedPlaces;
        this.contentBasedFiltering = contentBasedFiltering;
        this.findUserRecommendedPlaces = findUserRecommendedPlaces;
        this.districtRepository = districtRepository;
        this.userRecordNodeRepository = userRecordNodeRepository;
    }

    public User createUser(CreateUserRequest request) {
        logger.info("Create user {}", request.getUsername());

        User user = new User();

//        user.setName(request.getName());
        // TODO: make sure this username doesn't exist.
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setRoles(request.getRoles());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userNodeRepository.save(user);

        return user;
    }

    public UserSubCategoryDTO saveOrUpdateUserLikeSubCategories(UserSubCategoryDTO updateDTO) {

        UserRecordNode userRecordNode = new UserRecordNode();
        ArrayList<String> userLikeSubCategories = new ArrayList<>();

        String username = AuthenticatedUserUtil.getAuthenticatedUsername();

        // check user old or new
        Boolean oldUser = userNodeRepository.userAlreadyCreatedLikedFields(username);

        // find user in the db, exist or not
        Optional<User> userOptional = userNodeRepository.findUserByUsername(username);
        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));

        // if old user delete previous records
        if (oldUser) {
            logger.info("Delete previous created user records");
            userNodeRepository.deleteAllUserLikedFields(user.getUsername());
            userNodeRepository.deleteAllUserRecommendedPlaces(user.getUsername());
        }

        // create new relationship with subcategories
        List<UserLikeSubCategoryQueryResult> userLikeSubCategoryQueryResults = userNodeRepository.createUserInterestedFieldsRelationship(
                username,
                updateDTO.getLikeSubCategories());

//        List<Place> places = contentBasedFiltering.contentBasedRecommendation(username);
//        String[] placesNames = contentBasedFiltering.contentBasedRecommendationNames(username);

//        userNodeRepository.createUserRecommendPlacesRelationship(username, placesNames);
//        userRecord.setRecommendPlaces(places);
//        userRecordRepository.save(userRecord);

        // prepare return data
        for (UserLikeSubCategoryQueryResult result : userLikeSubCategoryQueryResults) {
            userLikeSubCategories.add(result.getSubCategoryName());
        }
        // Convert the List to a String array
        String[] stringArray = userLikeSubCategories.toArray(new String[0]);
        return new UserSubCategoryDTO(stringArray);
    }

    @Async
    public void generateRecommendedPlacesForUser(String userName) {
        UserRecommendedPlacesContext context = new UserRecommendedPlacesContext();

        context.setUserName(userName);
        userRecommendedPlacesGenerator.execute(context);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Service class created");
    }

    public List<UserLikedFieldsResult> getUserLikeSubCategories() {
        String username = AuthenticatedUserUtil.getAuthenticatedUsername();
        return userNodeRepository.getUserLikedSubCategories2(username);
    }

    public UserLikedNotLikedSubCategoryDTO getUserLikedAndNotLikedSubCategories() {
        String username = AuthenticatedUserUtil.getAuthenticatedUsername();
        List<UserLikedFieldsResult> userNotLikedSubCategories = userNodeRepository.getUserNotLikedSubCategories(username);
        List<UserLikedFieldsResult> userLikedSubCategories = userNodeRepository.getUserLikedSubCategories2(username);
        return new UserLikedNotLikedSubCategoryDTO(userLikedSubCategories, userNotLikedSubCategories);
    }

    public UserRecordNode saveUserDestination(UserRecordDTO updateDTO) {
        String username = AuthenticatedUserUtil.getAuthenticatedUsername();
        Optional<User> userOptional = userNodeRepository.findUserByUsername(username);
//        Optional<District> districtOptional = districtRepository.findDistrictByName(updateDTO.getDistrict());

        // Convert Optional<User> to User
        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));
//        District district1 = districtOptional.orElseThrow(() -> new RuntimeException("District not found"));

        UserRecordNode userRecordNode = new UserRecordNode();

        // update userRecord details
        userRecordNode.setUserID(user.getID());
//        userRecord.setUser(user);
        userRecordNode.setDistrict(updateDTO.getDistrict());
        userRecordNodeRepository.save(userRecordNode);
        return userRecordNode;

//        findUserRecommendedPlaces.executeCollaborativeFiltering(district);
    }

}
