package Locationbased.Recommendation.System.Neo4j.models.dto;

import lombok.Data;

@Data
public class UserSubCategoryDTO {

    private String location;

    private String[] likeSubCategories;

    public UserSubCategoryDTO(String[] likeSubCategories) {
        this.likeSubCategories = likeSubCategories;
    }

    public UserSubCategoryDTO() {
    }
}
