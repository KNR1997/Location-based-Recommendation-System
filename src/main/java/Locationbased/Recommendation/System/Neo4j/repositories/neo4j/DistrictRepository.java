package Locationbased.Recommendation.System.Neo4j.repositories.neo4j;

import Locationbased.Recommendation.System.Neo4j.models.node.District;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface DistrictRepository extends Neo4jRepository<District, Long> {
    Optional<District> findDistrictByName(String name);

}
