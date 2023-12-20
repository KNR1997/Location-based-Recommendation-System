package Locationbased.Recommendation.System.Neo4j.repositories.neo4j;

import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceHasFeatureQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserRatePlaceQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface PlaceNodeRepository extends Neo4jRepository<Place, Long> {

    @Query("MATCH (place:Place {name: $placeName})" +
            "WITH place, $subCategories AS subCategories " +
            "UNWIND subCategories AS subCategory " +
            "MATCH (feature:SubCategory {name: subCategory})" +
            "CREATE (place)-[:HAS_FEATURE]->(feature) RETURN feature.name AS subCategory,place.name AS placeName")
    List<PlaceHasFeatureQueryResult> createPlaceAndSubCategoryRelationship(String placeName, String[] subCategories);

    @Query("MATCH (place:Place {name: $placeName}) " +
            "RETURN EXISTS((place)-[:HAS_FEATURE]->())")
    Boolean placeHasSubCategoryRelationship(String placeName);

    @Query("MATCH (place:Place {name: $placeName})" +
            "-[r:HAS_FEATURE]->() " +
            "DELETE r")
    void deletePlaceSubCategoryRelationship(String placeName);

    @Query("MATCH (place:Place {name: $placeName})-[:HAS_FEATURE]->(subCategory:SubCategory) " +
            "RETURN subCategory.name")
    List<String> getPlaceSubCategory(String placeName);

    @Query("MATCH (user:User {username: $username})" +
            "MATCH (place:Place {name: $placeName})" +
            "MERGE (user)-[rating:RATE {rate: $rating}]->(place) " +
            "RETURN user.username AS username, place.name AS placeName, rating.rate AS rating")
    UserRatePlaceQueryResult ratePlace(String username, String placeName, Float rating);

}
