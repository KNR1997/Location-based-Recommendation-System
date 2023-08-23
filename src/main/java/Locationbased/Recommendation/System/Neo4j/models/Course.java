package Locationbased.Recommendation.System.Neo4j.models;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@Node
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String identifier;

    private String title;

    private String teacher;

//    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
//    private List<Lesson> lessons = new ArrayList<>();

    public Course() {
    }
}
