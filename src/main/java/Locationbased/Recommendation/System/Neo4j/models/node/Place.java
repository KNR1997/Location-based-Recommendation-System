package Locationbased.Recommendation.System.Neo4j.models.node;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@Node
public class Place {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Relationship(type = "HAS_SUBCATEGORY", direction = Relationship.Direction.OUTGOING)
    private List<SubCategory> subCategories = new ArrayList<>();
    @Relationship(type = "LOCATED_IN", direction = Relationship.Direction.OUTGOING)
    private List<District> districts = new ArrayList<>();
}
