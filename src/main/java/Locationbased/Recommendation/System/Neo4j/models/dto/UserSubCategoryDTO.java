package Locationbased.Recommendation.System.Neo4j.models.dto;

import lombok.Data;

@Data
public class UserSubCategoryDTO {

    private String[] likeSubCategories;

    public UserSubCategoryDTO() {
    }

    public UserSubCategoryDTO(String[] subCategories) {
        this.likeSubCategories = subCategories;

    }
}
