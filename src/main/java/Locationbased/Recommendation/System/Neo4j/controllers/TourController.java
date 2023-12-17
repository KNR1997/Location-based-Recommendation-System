package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.TourDTO;
import Locationbased.Recommendation.System.Neo4j.service.tour.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tour")
public class TourController {

    @Autowired
    private TourService tourService;

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/saveOrUpdateTour", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<TourDTO> saveOrUpdateTour(@RequestBody TourDTO updateDTO) {
        TourDTO result = tourService.saveOrUpdateTour(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
