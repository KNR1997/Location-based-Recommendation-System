package Locationbased.Recommendation.System.Neo4j.services;

import Locationbased.Recommendation.System.Neo4j.queryResult.GetUserRatePlacesByCategoriesQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PlaceRecommendationService {

    private final UserService userService;

    private final UserRepository userRepository;

    public PlaceRecommendationService(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Async
    public void recommendPlacesForUser(String userName) {

        // select relevant places
        List<String> relevantPlaces = new ArrayList<>();

        // get similar users
        CompletableFuture<List<String>> similarUsersResults = userService.findSimilarUsers(userName);

        // get newUser liked fields
        List<String> newUserLikedFields = userService.getUserLikeSubCategories(userName);

        // select relevant places
        similarUsersResults.thenApply(similarUsers -> {
            for (String similarUser : similarUsers) {
                // Create a list to store the similar categories
                List<String> similarCategories = new ArrayList<>();

                // Get similar categories and add to a List
                List<String> similarUserLikeCategories = userService.getUserLikeSubCategories(similarUser);
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
            return null;
        });

        // aggregate place data

        // filter and sort places

        //generate recommendations
        // Convert the list to an array
        String[] relevantPlacesArray = relevantPlaces.toArray(new String[relevantPlaces.size()]);
        userRepository.createUserRecommendPlacesRelationship(userName, relevantPlacesArray);
    }
}
