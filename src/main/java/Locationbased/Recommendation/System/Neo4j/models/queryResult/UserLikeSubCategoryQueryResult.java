package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.node.User;
import lombok.Data;

@Data
public class UserLikeSubCategoryQueryResult {

    private User user;

    private String subCategoryName;

    public UserLikeSubCategoryQueryResult() {
    }
}
