package Locationbased.Recommendation.System.Neo4j.models.dto;

import lombok.Data;

@Data
public class UserAuthDTO{

    private String username;

    private String token;

    public UserAuthDTO(String username, String token) {
        this.username = username;
        this.token = token;
    }
}
