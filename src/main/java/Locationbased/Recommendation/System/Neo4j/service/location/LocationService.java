package Locationbased.Recommendation.System.Neo4j.service.location;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Location;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location addLocation(Location location) {
        location.setId(UUID.randomUUID().toString().split("-")[0]);
        return locationRepository.save(location);
    }

    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(String locationId) {
        return locationRepository.findById(locationId).get();
    }

    public Location updateLocation(Location locationRequest) {
        Location existingPlace = locationRepository.findById(locationRequest.getId()).get();
        existingPlace.setName(locationRequest.getName());
        existingPlace.setImg(locationRequest.getImg());
        return locationRepository.save(existingPlace);
    }

    public String deleteLocation(String locationId) {
        locationRepository.deleteById(locationId);
        return locationId + "location deleted from dashboard";
    }

}
