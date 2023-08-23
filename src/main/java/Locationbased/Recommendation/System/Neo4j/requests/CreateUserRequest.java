package Locationbased.Recommendation.System.Neo4j.requests;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String username;
    private String password;
    private String roles;

    public CreateUserRequest(String name, String username, String password, String roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
