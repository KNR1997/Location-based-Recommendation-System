package Locationbased.Recommendation.System.Neo4j.services;

import Locationbased.Recommendation.System.Neo4j.models.Interest;
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

    public InterestFieldService(UserRepository userRepository, InterestFieldRepository interestFieldRepository) {
        this.interestFieldRepository = interestFieldRepository;
        this.userRepository = userRepository;
    }

    public UserLikeQueryResult userLikeFieldsCreate(String username, ArrayList<Interest> interestArrayList) {
        String[] interestFields = new String[interestArrayList.size()];
        for (int i = 0; i < interestArrayList.size(); i++) {
            interestFields[i] = interestArrayList.get(i).getName();
        }
        List<UserLikeQueryResult> userLikeQueryResults = userRepository.createUserInterestedFieldsRelationship(username, interestFields);
        return userLikeQueryResults.get(0);
    }

    public List<Interest> getAllInterestFields() {
        return interestFieldRepository.findAll();
    }

    public List<Interest> getUserLikedInterestFields(String userName){
        List<Interest> interestList = new ArrayList<>();
        List<UserLikedFieldsResult> interestFields =  userRepository.getUserLikedInterestFields(userName);
        for (UserLikedFieldsResult userLikedFieldsResult: interestFields) {
            interestList.add(new Interest(userLikedFieldsResult));
        }
        return interestList;
    }
}
