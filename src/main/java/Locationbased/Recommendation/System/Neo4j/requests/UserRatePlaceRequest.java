package Locationbased.Recommendation.System.Neo4j.requests;

import lombok.Data;

@Data
public class UserRatePlaceRequest {

    private String userName;

    private String placeName;

    private Integer rating;
}
