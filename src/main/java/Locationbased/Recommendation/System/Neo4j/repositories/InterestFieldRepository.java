package Locationbased.Recommendation.System.Neo4j.repositories;

import Locationbased.Recommendation.System.Neo4j.models.Interest;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface InterestFieldRepository extends Neo4jRepository<Interest, Long> {
}
