package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.node.UserRecordNode;
import lombok.Data;

@Data
public class UserRecordDTO {

    private Long userRecordID;

    private Long userID;

    private String district;

    private String[] likeSubCategories;

    private String[] recommendPlaces;

    public UserRecordDTO() {
    }

    public UserRecordDTO(UserRecordNode userRecordNode) {
        this.userRecordID = userRecordNode.getID();
        this.userID = userRecordNode.getUserID();
        this.likeSubCategories = userRecordNode.getLikeSubCategories();
        this.recommendPlaces = userRecordNode.getRecommendPlaces();
    }
}
