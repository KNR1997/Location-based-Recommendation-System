package Locationbased.Recommendation.System.Neo4j.models.mongoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "places")
public class Place {

    @Id
    private String id;

    private String title;

    private String city;

    private String address;

    private String distance;

    private String description;

    private String reviews;
}
