package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.node.District;
import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import Locationbased.Recommendation.System.Neo4j.models.node.PlaceCategory;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import lombok.Data;

import java.util.List;

@Data
public class PlaceDTO {

    private Long placeID;

    private String name;

    private List<District> districts;

    private List<SubCategory> subCategories;

    private List<PlaceCategory> placeCategories;

    public PlaceDTO() {
    }

    public PlaceDTO(Place place) {
        this.placeID = place.getID();
        this.name = place.getName();
        this.districts = place.getDistricts();
        this.subCategories = place.getSubCategories();
        this.placeCategories = place.getPlaceCategories();
    }

}
