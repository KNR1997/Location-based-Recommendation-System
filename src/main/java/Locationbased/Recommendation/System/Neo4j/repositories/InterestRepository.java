package Locationbased.Recommendation.System.Neo4j.repositories;

import Locationbased.Recommendation.System.Neo4j.models.InterestField;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface InterestRepository extends Neo4jRepository<InterestField, Long> {
}
