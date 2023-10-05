package Locationbased.Recommendation.System.Neo4j.dtos;

import Locationbased.Recommendation.System.Neo4j.queryResult.InterestFieldQueryResult;
import lombok.Data;

import java.util.List;

@Data
public class InterestFieldDTO {

    private String name;

    private List<InterestFieldQueryResult> subCategories;

    public InterestFieldDTO() {
    }

    public InterestFieldDTO(String name, List<InterestFieldQueryResult> subCategories) {
        this.name = name;
        this.subCategories = subCategories;
    }
}
