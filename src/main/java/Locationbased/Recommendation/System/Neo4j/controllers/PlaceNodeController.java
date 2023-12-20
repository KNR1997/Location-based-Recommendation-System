package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceFeatureDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import Locationbased.Recommendation.System.Neo4j.service.PlaceNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/PlaceNode")
public class PlaceNodeController {
    @Autowired
    private PlaceNodeService placeNodeService;

    @RequestMapping(value = "/addPlaceFeature", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<PlaceFeatureDTO> addPlaceFeature(@RequestBody PlaceFeatureDTO updateDTO) {
        PlaceFeatureDTO result = placeNodeService.saveOrUpdatePlaceFeature(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/getAllPlaces", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<List<Place>> getAllPlaces() {
        List<Place> places = placeNodeService.getAllPlaces();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @RequestMapping(value = "/ratePlace", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<PlaceRateDTO> ratePlace(@RequestBody PlaceRateDTO updateDTO) {
        PlaceRateDTO result = placeNodeService.ratePlace(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
