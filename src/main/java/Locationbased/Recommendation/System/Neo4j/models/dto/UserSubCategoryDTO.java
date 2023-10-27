package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikeSubCategoryQueryResult;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserSubCategoryDTO {

    private String userName;
    private String[] likeSubCategories;

    public UserSubCategoryDTO() {
    }

    public UserSubCategoryDTO(String userName, String[] subCategories) {
        this.userName = userName;
        this.likeSubCategories = subCategories;

    }
}
