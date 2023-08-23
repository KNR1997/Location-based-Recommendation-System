package Locationbased.Recommendation.System.Neo4j.models;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class Lesson {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String identifier;

    public Lesson() {
    }
}
