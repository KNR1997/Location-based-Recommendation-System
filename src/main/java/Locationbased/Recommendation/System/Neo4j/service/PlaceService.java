package Locationbased.Recommendation.System.Neo4j.service;

import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Place;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Rating;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.PlaceRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RatingRepository ratingRepository;


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
        existingPlace.setAvgRating(placeRequest.getAvgRating());
        return placeRepository.save(existingPlace);
    }

    public String deletePlace(String placeId) {
        placeRepository.deleteById(placeId);
        return placeId + "place deleted from dashboard";
    }

    public PlaceRateDTO saveOrUpdatePlaceRate(PlaceRateDTO placeRateDTO) {

        Rating rating;
        boolean isNewRating = (placeRateDTO.getRatingID() == null);

        if (!isNewRating) {
            rating = this.ratingRepository.findByid(placeRateDTO.getRatingID());
            rating.setRating(placeRateDTO.getRating());
        } else {
            rating = new Rating();

            rating.setUserID(placeRateDTO.getUserID());
            rating.setPlaceID(placeRateDTO.getPlaceID());
            rating.setRating(placeRateDTO.getRating());
        }

        rating = this.ratingRepository.save(rating);
        return new PlaceRateDTO(rating);
    }
}
