package Locationbased.Recommendation.System.Neo4j.services;

import Locationbased.Recommendation.System.Neo4j.dtos.InterestFieldDTO;
import Locationbased.Recommendation.System.Neo4j.models.Interest;
import Locationbased.Recommendation.System.Neo4j.models.SubCategory;
import Locationbased.Recommendation.System.Neo4j.queryResult.InterestFieldQueryResult;
import Locationbased.Recommendation.System.Neo4j.queryResult.UserLikeQueryResult;
import Locationbased.Recommendation.System.Neo4j.queryResult.UserLikedFieldsResult;
import Locationbased.Recommendation.System.Neo4j.repositories.InterestFieldRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterestFieldService {

    private final UserRepository userRepository;

    private final InterestFieldRepository interestFieldRepository;

    private final UserService userService;

    public InterestFieldService(UserRepository userRepository, InterestFieldRepository interestFieldRepository, UserService userService) {
        this.interestFieldRepository = interestFieldRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public List<InterestFieldDTO> getAllInterestFields() {
        List<Interest> interestList = interestFieldRepository.findAll();
        List<InterestFieldDTO> interestFieldDTOList = new ArrayList<>();
        for (Interest interest : interestList) {
            List<InterestFieldQueryResult> interestSubCategories = interestFieldRepository.getInterestFieldSubCategories(interest.getName());
            InterestFieldDTO interestFieldDTO = new InterestFieldDTO(interest.getName(), interestSubCategories);
            interestFieldDTOList.add(interestFieldDTO);
        }
        return interestFieldDTOList;
    }

    public UserLikeQueryResult createUserLikeFields(String username, ArrayList<SubCategory> interestArrayList) {
        List<String> subCategories = new ArrayList<>();
        for (SubCategory subCategory : interestArrayList) {
            subCategories.add(subCategory.getName());
        }
        if (userRepository.userAlreadyCreatedLikedFields(username)) {
            this.deleteAllUserLikedFields(username);
        }
        // Convert the list to an array
        String[] stringArray = subCategories.toArray(new String[subCategories.size()]);
        List<UserLikeQueryResult> userLikeQueryResults = userRepository.createUserInterestedFieldsRelationship(username, stringArray);
        userService.findSimilarUsers(username);
        return userLikeQueryResults.get(0);
    }

    public List<Interest> getUserLikedFields(String userName) {
        List<Interest> interestList = new ArrayList<>();
        List<UserLikedFieldsResult> interestFields = userRepository.getUserLikedInterestFields(userName);
        for (UserLikedFieldsResult userLikedFieldsResult : interestFields) {
            interestList.add(new Interest(userLikedFieldsResult));
        }
        return interestList;
    }

    void deleteAllUserLikedFields(String userName) {
        userRepository.deleteAllUserLikedFields(userName);
    }

}
