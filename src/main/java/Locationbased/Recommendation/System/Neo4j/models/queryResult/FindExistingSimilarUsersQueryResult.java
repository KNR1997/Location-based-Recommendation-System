package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.User;
import lombok.Data;

@Data
public class FindExistingSimilarUsersQueryResult {

    private User similarUser;
}
