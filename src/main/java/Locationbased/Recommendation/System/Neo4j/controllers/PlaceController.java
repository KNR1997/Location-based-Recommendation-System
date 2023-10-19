package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceFeatureDTO;
import Locationbased.Recommendation.System.Neo4j.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Place")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @RequestMapping(value = "/addPlaceFeature", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<PlaceFeatureDTO> addPlaceFeature(@RequestBody PlaceFeatureDTO updateDTO) {
        PlaceFeatureDTO result = placeService.saveOrUpdatePlaceFeature(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
