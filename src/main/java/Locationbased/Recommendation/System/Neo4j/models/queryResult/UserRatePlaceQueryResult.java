package Locationbased.Recommendation.System.Neo4j.queryResult;

import lombok.Data;

@Data
public class UserRatePlaceQueryResult {

    private String username;

    private String placeName;

    private Integer rating;
}
