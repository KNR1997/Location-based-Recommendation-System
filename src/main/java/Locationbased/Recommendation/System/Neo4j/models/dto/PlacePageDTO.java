package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Place;
import lombok.Data;

import java.util.List;

@Data
public class PlacePageDTO {

    private List<Place> content;
    private int totalPages;

    public PlacePageDTO(List<Place> content, int totalPages) {
        this.content = content;
        this.totalPages = totalPages;
    }
}
