package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.node.User;
import lombok.Data;

@Data
public class UserDTO {
    //    private String name;

    private Long userID;

    private String username;

    private String email;

    private String roles;

    private String password;


    public UserDTO(String username, String roles) {
//        this.name = name;
        this.username = username;
        this.roles = roles;
    }

    public UserDTO(User user) {
        this.userID = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.roles = user.getRoles();
    }
}
