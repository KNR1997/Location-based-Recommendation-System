package Locationbased.Recommendation.System.Neo4j.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.User;
import lombok.Data;

@Data
public class UserLikeQueryResult {

    private User user;

    private String fieldName;

    public UserLikeQueryResult() {
    }
}
