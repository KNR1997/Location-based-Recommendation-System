package Locationbased.Recommendation.System.Neo4j.models.dto;

import lombok.Data;

@Data
public class UserDTO {
    //    private String name;
    private String username;
    private String roles;

    public UserDTO(String username, String roles) {
//        this.name = name;
        this.username = username;
        this.roles = roles;
    }
}
