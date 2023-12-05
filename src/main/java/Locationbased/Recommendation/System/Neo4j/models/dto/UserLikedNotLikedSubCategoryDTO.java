package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikedFieldsResult;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserLikedNotLikedSubCategoryDTO {
    private List<UserLikedFieldsResult> userLikedSubCategories;
    private List<UserLikedFieldsResult> userNotLikedSubCategories;

    public UserLikedNotLikedSubCategoryDTO(List<UserLikedFieldsResult> userLikedSubCategories,
                                           List<UserLikedFieldsResult> userNotLikedSubCategories) {
        this.userLikedSubCategories = userLikedSubCategories;
        this.userNotLikedSubCategories = userNotLikedSubCategories;
    }
}
