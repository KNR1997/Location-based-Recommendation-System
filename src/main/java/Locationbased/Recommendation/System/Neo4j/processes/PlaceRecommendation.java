package Locationbased.Recommendation.System.Neo4j.processes;

import Locationbased.Recommendation.System.Neo4j.models.Place;
import Locationbased.Recommendation.System.Neo4j.queryResult.GetUserRatePlacesByCategoriesQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import Locationbased.Recommendation.System.Neo4j.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PlaceRecommendation {

    private final UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public PlaceRecommendation(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public void recommendPlacesForUser(String userName) {

        // select relevant places
        List<Place> relevantPlaces = new ArrayList<>();

        // get similar users
        List<String> similarUsers = userService.findSimilarUsers(userName);

        // get newUser liked fields
        List<String> newUserLikedFields = userService.getUserLikeSubCategories(userName);

        // select relevant places
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
            List<GetUserRatePlacesByCategoriesQueryResult> ratedPlaces = userRepository.getUserRatePlacesByCategories(similarUser ,stringArray);
            relevantPlaces.add((Place) ratedPlaces);
        }

        // aggregate place data

        // filter and sort places

        //generate recommendations
    }
}
