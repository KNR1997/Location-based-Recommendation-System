package Locationbased.Recommendation.System.Neo4j.algorithm;

import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.repositories.PlaceNodeRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ContentBasedFiltering {

    @Autowired
    private PlaceNodeRepository placeNodeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Place> contentBasedRecommendation(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        List<Place> recommendedLocations = new ArrayList<>();
        List<Place> allPlaces = placeNodeRepository.findAll();
        List<SubCategory> userLikedSubCategories = user.get().getLikedSubCategories();
        for (Place place : allPlaces) {
            List<SubCategory> placeSubCategories = place.getSubCategories();

            // Check if there is any common subcategory
            if (placeSubCategories.stream().anyMatch(userLikedSubCategories::contains)) {
                recommendedLocations.add(place);
            }
        }

        return recommendedLocations;
    }

}
