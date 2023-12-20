package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserRatePlaceQueryResult;
import lombok.Data;

@Data
public class PlaceRateDTO {
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
}
