package Locationbased.Recommendation.System.Neo4j.requests;

import lombok.Data;

@Data
public class PlaceAddFeaturesRequest {

    private String placeName;

    private String[] subCategories;
}
