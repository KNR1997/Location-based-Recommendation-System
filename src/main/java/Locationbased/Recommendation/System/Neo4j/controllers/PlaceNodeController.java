package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceFeatureDTO;
import Locationbased.Recommendation.System.Neo4j.service.PlaceNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/PlaceNode")
public class PlaceNodeController {
    @Autowired
    private PlaceNodeService placeNodeService;

    @PreAuthorize("hasAuthority('none')")
    @RequestMapping(value = "/addPlaceFeature", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<PlaceFeatureDTO> addPlaceFeature(@RequestBody PlaceFeatureDTO updateDTO) {
        PlaceFeatureDTO result = placeNodeService.saveOrUpdatePlaceFeature(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
