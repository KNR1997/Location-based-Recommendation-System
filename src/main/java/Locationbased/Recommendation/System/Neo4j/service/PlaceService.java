package Locationbased.Recommendation.System.Neo4j.services;

import Locationbased.Recommendation.System.Neo4j.queryResult.PlaceHasFeatureQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public PlaceHasFeatureQueryResult createPlaceHasFeature(String placeName, String[] subCategories) {
        List<PlaceHasFeatureQueryResult> placeHasFeatureQueryResults = placeRepository.createPlaceAndSubCategoryRelationship(placeName, subCategories);
        return placeHasFeatureQueryResults.get(0);
    }
}
