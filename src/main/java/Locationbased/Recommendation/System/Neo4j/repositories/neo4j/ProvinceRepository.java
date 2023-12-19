package Locationbased.Recommendation.System.Neo4j.repositories.neo4j;

import Locationbased.Recommendation.System.Neo4j.models.node.Province;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface ProvinceRepository extends Neo4jRepository<Province, Long> {

    @Query("MATCH (province:Province {name: $province})-[:HAS_DISTRICT]" +
            "->(district:District)-[:HAS_PLACE]->(place:Place) " +
            "RETURN place ")
    List<PlaceQueryResult> getAllPlacesInProvince(String province);
}
