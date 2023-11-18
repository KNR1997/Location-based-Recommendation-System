package Locationbased.Recommendation.System.Neo4j.models.dto;

import lombok.Data;

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
