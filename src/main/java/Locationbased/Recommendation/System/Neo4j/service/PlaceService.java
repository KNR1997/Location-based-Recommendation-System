package Locationbased.Recommendation.System.Neo4j.service;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Place;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    // CRUD
    public Place addPlace(Place place) {
        place.setId(UUID.randomUUID().toString().split("-")[0]);
        return placeRepository.save(place);
    }

    public List<Place> finAllPlaces() {
        return placeRepository.findAll();
    }

    public Place getPlaceByPlaceId(String placeId) {
        return placeRepository.findById(placeId).get();
    }

    public List<Place> getPlaceByCity(String city) {
        return placeRepository.findByCity(city);
    }

    public List<Place> getPlaceByTitle(String title) {
        return placeRepository.findByTitle(title);
    }

    public Place updatePlace(Place placeRequest) {
        // get the existing document from DB
        // populate new value from request to existing object/entity
        Place existingPlace = placeRepository.findById(placeRequest.getId()).get();
        existingPlace.setDescription(placeRequest.getDescription());
        existingPlace.setCity(placeRequest.getCity());
        existingPlace.setReviews(placeRequest.getReviews());
        return placeRepository.save(existingPlace);
    }

    public String deletePlace(String placeId) {
        placeRepository.deleteById(placeId);
        return placeId + "place deleted from dashboard";
    }
}
