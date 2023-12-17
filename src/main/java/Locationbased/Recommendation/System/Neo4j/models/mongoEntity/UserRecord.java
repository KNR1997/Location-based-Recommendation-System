package Locationbased.Recommendation.System.Neo4j.models.mongoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userRecord")
public class UserRecord {

    private String id;

    private Long userID;

    private String[] likeSubCategories;

    private List<Tour> tour;
}
