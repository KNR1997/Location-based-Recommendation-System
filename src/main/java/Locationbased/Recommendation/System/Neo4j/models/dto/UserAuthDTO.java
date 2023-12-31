package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import lombok.Data;

@Data
public class UserAuthDTO{

    private String username;

    private String token;

    private UserRecord userRecord;

    public UserAuthDTO(String username, String token, UserRecord userRecord) {
        this.username = username;
        this.token = token;
        this.userRecord = userRecord;
    }
}
