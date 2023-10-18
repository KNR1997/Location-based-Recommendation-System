package Locationbased.Recommendation.System.Neo4j.repositories;

import Locationbased.Recommendation.System.Neo4j.models.Place;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceHasFeatureQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface PlaceRepository extends Neo4jRepository<Place, Long> {

    @Query("MATCH (place:Place {name: $placeName})" +
            "WITH place, $subCategories AS subCategories " +
            "UNWIND subCategories AS subCategory " +
            "MATCH (feature:SubCategory {name: subCategory})" +
            "CREATE (place)-[:HAS_FEATURE]->(feature) RETURN feature.name AS subCategory,place.name AS placeName")
    List<PlaceHasFeatureQueryResult> createPlaceAndSubCategoryRelationship(String placeName, String[] subCategories);

}
