package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.node.PlaceNode;
import lombok.Data;

@Data
public class GetUserRatePlacesByCategoriesQueryResult {

    private PlaceNode placeNode;
}
