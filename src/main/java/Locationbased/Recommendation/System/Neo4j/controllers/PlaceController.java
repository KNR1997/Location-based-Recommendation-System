package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceHasFeatureQueryResult;
import Locationbased.Recommendation.System.Neo4j.requests.PlaceAddFeaturesRequest;
import Locationbased.Recommendation.System.Neo4j.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Place")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("/addFeatures")
    public ResponseEntity<PlaceHasFeatureQueryResult> addFeaturesToPlace(@RequestBody PlaceAddFeaturesRequest request) {
        PlaceHasFeatureQueryResult result = placeService.createPlaceHasFeature(request.getPlaceName(), request.getSubCategories());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
