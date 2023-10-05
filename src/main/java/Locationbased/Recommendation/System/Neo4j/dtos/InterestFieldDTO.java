package Locationbased.Recommendation.System.Neo4j.dtos;

import Locationbased.Recommendation.System.Neo4j.models.SubCategory;
import lombok.Data;

import java.util.List;

@Data
public class InterestField {
    
    private Long id;

    private String name;

    private List<SubCategory> subCategories;
}
