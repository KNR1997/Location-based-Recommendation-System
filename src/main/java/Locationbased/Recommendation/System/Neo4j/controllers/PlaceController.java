package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.PlacePageDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Place;
import Locationbased.Recommendation.System.Neo4j.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/addPlace", headers = "Accept=application/json", method = RequestMethod.POST)
    public Place createPlace(@RequestBody Place place) {
        return placeService.addPlace(place);
    }

    @RequestMapping(value = "/getAllPlaces", headers = "Accept=application/json", method = RequestMethod.GET)
    public List<Place> getPlaces() {
        return placeService.finAllPlaces();
    }

    @RequestMapping(value = "/{placeId}", headers = "Accept=application/json", method = RequestMethod.GET)
    public Place getPlace(@PathVariable String placeId) {
        return placeService.getPlaceByPlaceId(placeId);
    }

    @RequestMapping(value = "/city/{city}", headers = "Accept=application/json", method = RequestMethod.GET)
    public List<Place> getPlaceByCity(@PathVariable String city) {
        return placeService.getPlaceByCity(city);
    }

    @RequestMapping(value = "/title/{title}", headers = "Accept=application/json", method = RequestMethod.GET)
    public List<Place> getPlaceByTitle(@PathVariable String title) {
        return placeService.getPlaceByTitle(title);
    }

    @RequestMapping(headers = "Accept=application/json", method = RequestMethod.PUT)
    public Place updatePlace(@RequestBody Place placeRequest) {
        return placeService.updatePlace(placeRequest);
    }

    @RequestMapping(value = "/{placeId}", headers = "Accept=application/json", method = RequestMethod.DELETE)
    public String deletePlace(@PathVariable String placeId) {
        placeService.deletePlace(placeId);
        return placeId + "place deleted from dashboard";
    }

    @RequestMapping(value = "/ratePlace", headers = "Accept=application/json", method = RequestMethod.POST)
    public PlaceRateDTO ratePlace(@RequestBody PlaceRateDTO placeRateDTO) {
        return placeService.saveOrUpdatePlaceRate(placeRateDTO);
    }

    @RequestMapping(value = "/placeCategory/{category}/{pageNo}", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<PlacePageDTO> getPlaceByPlaceCategory(@PathVariable String category, @PathVariable Integer pageNo) {
        PlacePageDTO result = placeService.getPlaceByPlaceCategory(category, pageNo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/getFeaturedPlaces", headers = "Accept=application/json", method = RequestMethod.GET)
    public List<Place> getFeaturedPlaces() {
        return placeService.getFeaturedPlaces();
    }
}