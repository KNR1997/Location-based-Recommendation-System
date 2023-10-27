package Locationbased.Recommendation.System.Neo4j.service;

import Locationbased.Recommendation.System.Neo4j.models.queryResult.GetUserRatePlacesByCategoriesQueryResult;
import Locationbased.Recommendation.System.Neo4j.process.UserProcess;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlaceRecommendationService {

    private final UserProcess userProcess;

    private final UserRepository userRepository;

    public PlaceRecommendationService(UserProcess userProcess, UserRepository userRepository) {
        this.userProcess = userProcess;
        this.userRepository = userRepository;
    }

    public Set<String> recommendPlacesForUser(String userName, List<String> similarUsers) {

        // select relevant places
        Set<String> relevantPlaces = new HashSet<>();

        // get newUser liked fields
        List<String> newUserLikedFields = userProcess.getUserLikeSubCategories(userName);

        // select relevant places
        for (String similarUser : similarUsers) {
            // Create a list to store the similar categories
            List<String> similarCategories = new ArrayList<>();

            // Get similar categories and add to a List
            List<String> similarUserLikeCategories = userProcess.getUserLikeSubCategories(similarUser);
            for (String similarUserCategory : similarUserLikeCategories) {
                if (newUserLikedFields.contains(similarUserCategory)) {
                    similarCategories.add(similarUserCategory);
                }
            }

            // Convert the list to an array
            String[] stringArray = similarCategories.toArray(new String[similarCategories.size()]);

            // Get rated places and add to relevant places
            List<GetUserRatePlacesByCategoriesQueryResult> ratedPlaces = userRepository.getUserRatePlacesByCategories(similarUser, stringArray);
            for (GetUserRatePlacesByCategoriesQueryResult ratePlace : ratedPlaces) {
                relevantPlaces.add(ratePlace.getPlace().getName());
            }
        }
        return relevantPlaces;
    }
}
