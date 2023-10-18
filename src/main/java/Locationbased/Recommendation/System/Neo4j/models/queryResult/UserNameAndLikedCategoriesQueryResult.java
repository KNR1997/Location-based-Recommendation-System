package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import lombok.Data;

@Data
public class UserNameAndLikedCategoriesQueryResult {

    private String userName;

    private String categoryName;
}
