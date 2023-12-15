package Locationbased.Recommendation.System.Neo4j.models.node;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Data
@Node
public class UserRecord {
    @Id
    @GeneratedValue
    private Long id;
    @Relationship(type = "HAS", direction = Relationship.Direction.INCOMING)
    private User user = new User();
    private String province;
    private String district;

}
