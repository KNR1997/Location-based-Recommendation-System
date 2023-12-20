package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Rating;
import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserRatePlaceQueryResult;
import lombok.Data;

@Data
public class PlaceRateDTO {

    private String ratingID;

    private Long userID;

    private String placeID;

    private String userName;

    private String placeName;

    private Float rating;

    public PlaceRateDTO() {
    }

    public PlaceRateDTO(UserRatePlaceQueryResult userRatePlaceQueryResult) {
        this.userName = userRatePlaceQueryResult.getUsername();
        this.placeName = userRatePlaceQueryResult.getPlaceName();
        this.rating = userRatePlaceQueryResult.getRating();
    }

    public PlaceRateDTO(Rating rating) {
        this.ratingID = rating.getId();
        this.userID = rating.getUserID();
        this.placeID = rating.getPlaceID();
        this.rating = rating.getRating();
    }
}
