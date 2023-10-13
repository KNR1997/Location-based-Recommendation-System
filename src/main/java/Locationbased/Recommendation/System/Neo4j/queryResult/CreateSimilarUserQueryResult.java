package Locationbased.Recommendation.System.Neo4j.queryResult;

import lombok.Data;

@Data
public class CreateSimilarUserQueryResult {

    private String userName;

    private String similarUser;
}
