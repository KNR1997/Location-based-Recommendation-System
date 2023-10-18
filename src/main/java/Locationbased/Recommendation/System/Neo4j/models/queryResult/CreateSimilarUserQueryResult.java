package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import lombok.Data;

@Data
public class CreateSimilarUserQueryResult {

    private String userName;

    private String similarUser;
}
