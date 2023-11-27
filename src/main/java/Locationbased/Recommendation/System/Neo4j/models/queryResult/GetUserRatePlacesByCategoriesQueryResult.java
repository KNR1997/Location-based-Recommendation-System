package Locationbased.Recommendation.System.Neo4j.models.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import lombok.Data;

@Data
public class GetUserRatePlacesByCategoriesQueryResult {

    private Place place;
}
