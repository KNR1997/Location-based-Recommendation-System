package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.node.UserNode;
import lombok.Data;

@Data
public class UserLikeSubCategoryQueryResult {

    private UserNode userNode;

    private String subCategoryName;

    public UserLikeSubCategoryQueryResult() {
    }
}
