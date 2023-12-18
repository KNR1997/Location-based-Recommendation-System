package Locationbased.Recommendation.System.Neo4j.repositories.neo4j;

import Locationbased.Recommendation.System.Neo4j.models.node.District;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.ProvinceQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface DistrictRepository extends Neo4jRepository<District, Long> {
    District findDistrictByname(String name);

    @Query("MATCH (province:Province)-[:HAS_DISTRICT]->(district:District) " +
            "WHERE district.name = $district " +
            "RETURN province")
    ProvinceQueryResult findProvince(String district);

}
