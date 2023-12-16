package Locationbased.Recommendation.System.Neo4j.models.node;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Data
@Node
public class UserRecord {

    @Id
    @GeneratedValue
    private Long ID;

    private Long userID;

    private String province;

    private String district;

    private String[] likeSubCategories;

    private String[] recommendPlaces;

}
