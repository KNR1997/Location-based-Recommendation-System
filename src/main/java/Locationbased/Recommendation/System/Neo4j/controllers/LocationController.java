package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Location;
import Locationbased.Recommendation.System.Neo4j.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/addLocation", headers = "Accept=application/json", method = RequestMethod.POST)
    public Location createLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }

    @RequestMapping(value = "/getAllLocations", headers = "Accept=application/json", method = RequestMethod.GET)
    public List<Location> getPlaces() {
        return locationService.findAllLocations();
    }

    @RequestMapping(headers = "Accept=application/json", method = RequestMethod.PUT)
    public Location updateLocation(@RequestBody Location updateRequest) {
        return locationService.updateLocation(updateRequest);
    }

    @RequestMapping(value = "/{placeId}", headers = "Accept=application/json", method = RequestMethod.DELETE)
    public String deleteLocation(@PathVariable String locationId) {
        locationService.deleteLocation(locationId);
        return locationId + "location deleted from dashboard";
    }
}
