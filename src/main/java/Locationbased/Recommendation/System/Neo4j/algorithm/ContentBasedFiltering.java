package Locationbased.Recommendation.System.Neo4j.algorithm;

import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.PlaceNodeRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ContentBasedFiltering {

    @Autowired
    private PlaceNodeRepository placeNodeRepository;

    @Autowired
    private UserNodeRepository userNodeRepository;

    public List<Place> contentBasedRecommendation(String username) {
        Optional<User> user = userNodeRepository.findUserByUsername(username);
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

    public String[] contentBasedRecommendationNames(String username) {
        Optional<User> user = userNodeRepository.findUserByUsername(username);
        List<String> recommendedLocationNames = new ArrayList<>();
        List<Place> allPlaces = placeNodeRepository.findAll();
        List<SubCategory> userLikedSubCategories = user.isPresent() ?
                user.get().getLikedSubCategories() : Collections.emptyList();

        for (Place place : allPlaces) {
            List<SubCategory> placeSubCategories = place.getSubCategories();

            // Check if there is any common subcategory
            if (placeSubCategories.stream().anyMatch(userLikedSubCategories::contains)) {
                recommendedLocationNames.add(place.getName());
            }
        }

        return recommendedLocationNames.toArray(new String[0]);
    }

}
