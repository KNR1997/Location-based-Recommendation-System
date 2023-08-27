package Locationbased.Recommendation.System.Neo4j.services;

import Locationbased.Recommendation.System.Neo4j.models.Interest;
import Locationbased.Recommendation.System.Neo4j.queryResult.UserLikeQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.InterestFieldRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestFieldService {

    private final UserRepository userRepository;

    private final InterestFieldRepository interestFieldRepository;

    public InterestFieldService(UserRepository userRepository, InterestFieldRepository interestFieldRepository) {
        this.interestFieldRepository = interestFieldRepository;
        this.userRepository = userRepository;
    }

    public UserLikeQueryResult userLikeFieldsCreated(String username, String[] interestFields) {
        List<UserLikeQueryResult> userLikeQueryResults = userRepository.createUserInterestedFieldsRelationship(username, interestFields);
        return userLikeQueryResults.get(0);
    }

    public List<Interest> getAllInterestFields() {
        return interestFieldRepository.findAll();
    }
}
