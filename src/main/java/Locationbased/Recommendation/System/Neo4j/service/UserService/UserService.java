package Locationbased.Recommendation.System.Neo4j.service.UserService;

import Locationbased.Recommendation.System.Neo4j.algorithm.ContentBasedFiltering;
import Locationbased.Recommendation.System.Neo4j.algorithm.RecommendedPlaces;
import Locationbased.Recommendation.System.Neo4j.config.AuthenticatedUserUtil;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserLikedNotLikedSubCategoryDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserSubCategoryDTO;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikeSubCategoryQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikedFieldsResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserRatePlaceQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.SubCategoryRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import Locationbased.Recommendation.System.Neo4j.requests.CreateUserRequest;
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

    public UserService(UserNodeRepository userNodeRepository,
                       PasswordEncoder passwordEncoder,
                       UserRecommendedPlacesGenerator userRecommendedPlacesGenerator,
                       UserProcess userProcess,
                       SubCategoryRepository subCategoryRepository,
                       RecommendedPlaces recommendedPlaces,
                       ContentBasedFiltering contentBasedFiltering
    ) {
        this.userNodeRepository = userNodeRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRecommendedPlacesGenerator = userRecommendedPlacesGenerator;
        this.userProcess = userProcess;
        this.subCategoryRepository = subCategoryRepository;
        this.recommendedPlaces = recommendedPlaces;
        this.contentBasedFiltering = contentBasedFiltering;
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
        // Use the utility method to get the authenticated username
        String username = AuthenticatedUserUtil.getAuthenticatedUsername();
        ArrayList<String> userLikeSubCategories = new ArrayList<>();

        // Delete previously created relationships if exists
        if (userNodeRepository.userAlreadyCreatedLikedFields(username)) {
            logger.info("Delete previous created user like subCategories");
            this.deleteAllUserLikedFields(username);
        }

        recommendedPlaces.getRecommendedPlaces(updateDTO.getLocation(), updateDTO.getLikeSubCategories());

        List<UserLikeSubCategoryQueryResult> userLikeSubCategoryQueryResults = userNodeRepository.createUserInterestedFieldsRelationship(
                username,
                updateDTO.getLikeSubCategories());

//        List<Place> places = contentBasedFiltering.contentBasedRecommendation(username);
        String[] placesNames = contentBasedFiltering.contentBasedRecommendationNames(username);

        userNodeRepository.createUserRecommendPlacesRelationship(username, placesNames);

        for (UserLikeSubCategoryQueryResult result : userLikeSubCategoryQueryResults) {
            userLikeSubCategories.add(result.getSubCategoryName());
        }

        // Convert the List to a String array
        String[] stringArray = userLikeSubCategories.toArray(new String[0]);
        return new UserSubCategoryDTO(stringArray);
    }

    void deleteAllUserLikedFields(String userName) {
        userNodeRepository.deleteAllUserLikedFields(userName);
    }

    public PlaceRateDTO saveOrUpdatePlaceRating(PlaceRateDTO updateDTO) {

        boolean isNew = (!userNodeRepository.userRatedPlace(updateDTO.getUserName(), updateDTO.getPlaceName()));
        UserRatePlaceQueryResult result = null;

        if (isNew) {
            result = userNodeRepository.createUserRatePlaceRelationship(updateDTO.getUserName(), updateDTO.getPlaceName(), updateDTO.getRating());
        } else {
            result = userNodeRepository.updateUserRatePlaceRelationship(updateDTO.getUserName(), updateDTO.getPlaceName(), updateDTO.getRating());
        }

        return new PlaceRateDTO(result);
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
}
