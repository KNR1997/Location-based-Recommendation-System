package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import lombok.Data;

import java.util.List;

@Data
public class UserRecordDTO {

    private String userRecordID;

    private Long userID;

    private String district;

    private List<SubCategory> likeSubCategories;

    private String[] recommendPlaces;

    public UserRecordDTO() {
    }

    public UserRecordDTO(UserRecord userRecord) {
        this.userRecordID = userRecord.getId();
        this.userID = userRecord.getUserID();
        this.likeSubCategories = userRecord.getLikeSubCategories();
    }
}
