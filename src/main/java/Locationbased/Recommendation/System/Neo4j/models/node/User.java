package Locationbased.Recommendation.System.Neo4j.models.node;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
public class UserNode {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    private String roles;

}
