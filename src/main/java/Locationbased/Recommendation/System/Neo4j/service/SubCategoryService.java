package Locationbased.Recommendation.System.Neo4j.service;

import Locationbased.Recommendation.System.Neo4j.config.AuthenticatedUserUtil;
import Locationbased.Recommendation.System.Neo4j.models.node.Interest;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikedFieldsResult;
import Locationbased.Recommendation.System.Neo4j.repositories.InterestFieldRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.SubCategoryRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryService {

    private final UserRepository userRepository;

    private final InterestFieldRepository interestFieldRepository;

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(UserRepository userRepository,
                              InterestFieldRepository interestFieldRepository,
                              SubCategoryRepository subCategoryRepository) {
        this.interestFieldRepository = interestFieldRepository;
        this.userRepository = userRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategory> getAllActiveSubCategories() {
        return subCategoryRepository.findAllActiveSubCategories();
    }

    public List<Interest> getUserLikedSubCategories(String userName) {
        List<Interest> interestList = new ArrayList<>();
        List<UserLikedFieldsResult> interestFields = userRepository.getUserLikedInterestFields(userName);
        for (UserLikedFieldsResult userLikedFieldsResult : interestFields) {
            interestList.add(new Interest(userLikedFieldsResult));
        }
        return interestList;
    }

//    public UserSubCategoryDTO saveOrUpdateUserLikeSubCategories(UserSubCategoryDTO updateDTO) {
//        ArrayList<String> userLikeSubCategories = new ArrayList<>();
//        if (userRepository.userAlreadyCreatedLikedFields(updateDTO.getUserName())) {
//            this.deleteAllUserLikedFields(updateDTO.getUserName());
//        }
//        List<UserLikeSubCategoryQueryResult> userLikeSubCategoryQueryResults = userRepository.createUserInterestedFieldsRelationship(
//                updateDTO.getUserName(),
//                updateDTO.getLikeSubCategories());
//        generateRecommendedPlacesForUser(updateDTO.getUserName());
//        for (UserLikeSubCategoryQueryResult result:userLikeSubCategoryQueryResults) {
//            userLikeSubCategories.add(result.getSubCategoryName());
//        }
//        // Convert the List to a String array
//        String[] stringArray = userLikeSubCategories.toArray(new String[0]);
//        return new UserSubCategoryDTO(updateDTO.getUserName(), stringArray);
//    }
//
//    void deleteAllUserLikedFields(String userName) {
//        userRepository.deleteAllUserLikedFields(userName);
//    }
//
//    @Async
//    public void generateRecommendedPlacesForUser(String userName) {
//        UserRecommendedPlacesContext context = new UserRecommendedPlacesContext();
//
//        context.setUserName(userName);
//        userRecommendedPlacesGenerator.execute(context);
//    }

}
