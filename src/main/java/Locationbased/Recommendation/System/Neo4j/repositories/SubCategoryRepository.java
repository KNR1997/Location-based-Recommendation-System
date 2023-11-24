package Locationbased.Recommendation.System.Neo4j.repositories;

import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SubCategoryRepository extends Neo4jRepository<SubCategory, Long> {
}
