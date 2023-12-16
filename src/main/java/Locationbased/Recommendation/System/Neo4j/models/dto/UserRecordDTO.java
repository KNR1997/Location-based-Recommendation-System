package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.node.UserRecord;
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

    public UserRecordDTO(UserRecord userRecord) {
        this.userRecordID = userRecord.getID();
        this.userID = userRecord.getUserID();
        this.likeSubCategories = userRecord.getLikeSubCategories();
        this.recommendPlaces = userRecord.getRecommendPlaces();
    }
}
