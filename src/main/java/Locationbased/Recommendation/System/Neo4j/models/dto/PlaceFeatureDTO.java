package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.place.PlaceFeature;
import lombok.Data;

import java.util.List;

@Data
public class PlaceFeatureDTO {

    private String placeName;

    private List<String> subCategory;

    public PlaceFeatureDTO() {
    }

    public PlaceFeatureDTO(PlaceFeature placeFeature) {
        this.placeName = placeFeature.getPlaceName();
        this.subCategory = placeFeature.getSubCategory();
    }
}
