package Locationbased.Recommendation.System.Neo4j.models;

import Locationbased.Recommendation.System.Neo4j.queryResult.UserLikedFieldsResult;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
public class Interest {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Interest() {
    }

    public Interest(UserLikedFieldsResult userLikedFieldsResult) {
        this.id = userLikedFieldsResult.getLikedField().getId();
        this.name = userLikedFieldsResult.getLikedField().getName();
    }
}
