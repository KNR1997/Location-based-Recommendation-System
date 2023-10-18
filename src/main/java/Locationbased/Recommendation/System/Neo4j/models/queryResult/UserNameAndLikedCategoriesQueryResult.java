package Locationbased.Recommendation.System.Neo4j.queryResult;

import lombok.Data;

@Data
public class UserNameAndLikedCategoriesQueryResult {

    private String userName;

    private String categoryName;
}
