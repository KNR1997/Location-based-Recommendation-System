package Locationbased.Recommendation.System.Neo4j.models.mongoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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

    private Float avgRating;

    private Float defaultRating;

    private Float calculatedRating;

    private Integer noRatings;

    private Boolean featured;

    private String cover;

    private List<String> images;
}
