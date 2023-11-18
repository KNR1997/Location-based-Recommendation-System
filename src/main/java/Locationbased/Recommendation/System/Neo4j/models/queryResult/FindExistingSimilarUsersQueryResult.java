package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.node.UserNode;
import lombok.Data;

@Data
public class FindExistingSimilarUsersQueryResult {

    private UserNode similarUserNode;
}
