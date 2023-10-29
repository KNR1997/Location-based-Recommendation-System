package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import lombok.Data;

@Data
public class CreateSimilarityRelationshipWithExistingUsersQueryResult {

    private String username;

    private Double rate;
}
