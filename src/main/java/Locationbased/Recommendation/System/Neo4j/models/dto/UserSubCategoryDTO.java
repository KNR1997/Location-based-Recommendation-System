package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikedFieldsResult;
import lombok.Data;

import java.util.List;

@Data
public class UserSubCategoryDTO {

    private String[] likeSubCategories;

    private List<UserLikedFieldsResult> likedSubCategories;

    public UserSubCategoryDTO() {
    }

    public UserSubCategoryDTO(String[] subCategories) {
        this.likeSubCategories = subCategories;

    }

    public UserSubCategoryDTO(List<UserLikedFieldsResult> subCategoryList) {
        this.likedSubCategories = subCategoryList;
    }
}
