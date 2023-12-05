package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import lombok.Data;

@Data
public class UserLikedAndNotLikedSubCategoryQueryResult {
    private SubCategory likedSubCategory;
    private SubCategory allSubCategories;

}
