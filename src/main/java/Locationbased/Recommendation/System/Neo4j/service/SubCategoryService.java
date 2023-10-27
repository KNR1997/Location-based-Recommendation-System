package Locationbased.Recommendation.System.Neo4j.service;

import Locationbased.Recommendation.System.Neo4j.models.Interest;
import Locationbased.Recommendation.System.Neo4j.models.dto.InterestFieldDTO;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.InterestFieldQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikedFieldsResult;
import Locationbased.Recommendation.System.Neo4j.repositories.InterestFieldRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryService {

    private final UserRepository userRepository;

    private final InterestFieldRepository interestFieldRepository;

    public SubCategoryService(UserRepository userRepository,
                              InterestFieldRepository interestFieldRepository) {
        this.interestFieldRepository = interestFieldRepository;
        this.userRepository = userRepository;
    }

    public List<InterestFieldDTO> getAllSubCategories() {
        List<Interest> interestList = interestFieldRepository.findAll();
        List<InterestFieldDTO> interestFieldDTOList = new ArrayList<>();
        for (Interest interest : interestList) {
            List<InterestFieldQueryResult> interestSubCategories = interestFieldRepository.getInterestFieldSubCategories(interest.getName());
            InterestFieldDTO interestFieldDTO = new InterestFieldDTO(interest.getName(), interestSubCategories);
            interestFieldDTOList.add(interestFieldDTO);
        }
        return interestFieldDTOList;
    }

    public List<Interest> getUserLikedSubCategories(String userName) {
        List<Interest> interestList = new ArrayList<>();
        List<UserLikedFieldsResult> interestFields = userRepository.getUserLikedInterestFields(userName);
        for (UserLikedFieldsResult userLikedFieldsResult : interestFields) {
            interestList.add(new Interest(userLikedFieldsResult));
        }
        return interestList;
    }
//
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
