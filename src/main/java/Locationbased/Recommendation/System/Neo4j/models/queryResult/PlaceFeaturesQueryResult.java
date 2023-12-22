package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import lombok.Data;

import java.util.List;

@Data
public class PlaceFeaturesQueryResult {

    private String placeName;

    private List<SubCategory> features;
}
