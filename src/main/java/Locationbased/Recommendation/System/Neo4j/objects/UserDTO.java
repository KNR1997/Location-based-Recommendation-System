package Locationbased.Recommendation.System.Neo4j.objects;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String username;
    private String roles;

    public UserDTO(String name, String username, String roles) {
        this.name = name;
        this.username = username;
        this.roles = roles;
    }
}
