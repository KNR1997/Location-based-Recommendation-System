package Locationbased.Recommendation.System.Neo4j.service;

import Locationbased.Recommendation.System.Neo4j.models.dto.PlacePageDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Place;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Rating;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.PlaceRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Place place = placeRepository.findByid(placeRateDTO.getPlaceID());

        if (!isNewRating) {
            rating = this.ratingRepository.findByid(placeRateDTO.getRatingID());
            place.setCalculatedRating(updateRatingAndCalculateNew(place, placeRateDTO.getRating(), place.getNoRatings()));
        } else {
            rating = new Rating();
            rating.setUserID(placeRateDTO.getUserID());
            rating.setPlaceID(placeRateDTO.getPlaceID());
            rating.setRating(placeRateDTO.getRating());

            place.setCalculatedRating(calculateNewRatingWithNewRating(place, placeRateDTO.getRating(), place.getNoRatings()));
        }

        place.setNoRatings(place.getNoRatings() + 1);
        placeRepository.save(place);

        rating = this.ratingRepository.save(rating);
        return new PlaceRateDTO(rating);
    }

    private float updateRatingAndCalculateNew(Place place, float newRating, int noRatings) {
        Float oldRating = place.getCalculatedRating();
        return (oldRating * noRatings + newRating) / (noRatings + 1);
    }

    private float calculateNewRatingWithNewRating(Place place, float newRating, int noRatings) {
        return (place.getDefaultRating() * noRatings + newRating) / (noRatings + 2);
    }

    public PlacePageDTO getPlaceByPlaceCategory(String placeCategory, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 8);
        Page<Place> placePage = placeRepository.findByPlaceCategory(placeCategory, pageable);

        List<Place> content = placePage.getContent();
        int totalPages = placePage.getTotalPages();

        return new PlacePageDTO(content, totalPages);
    }
}
