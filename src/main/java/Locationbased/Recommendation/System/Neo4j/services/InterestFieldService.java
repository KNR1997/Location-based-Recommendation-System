package Locationbased.Recommendation.System.Neo4j.services;

import Locationbased.Recommendation.System.Neo4j.queryResult.UserLikeQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestFieldService {

    private final UserRepository userRepository;

    public InterestFieldService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserLikeQueryResult userLikeFieldsCreated(String username, String[] interestFields) {
        List<UserLikeQueryResult> userLikeQueryResults = userRepository.createUserInterestedFieldsRelationship(username, interestFields);
        return userLikeQueryResults.get(0);
    }
}
