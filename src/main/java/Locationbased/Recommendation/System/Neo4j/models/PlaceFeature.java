package Locationbased.Recommendation.System.Neo4j.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class PlaceFeature {

    private String placeName;

    private List<String> subCategory;
}
