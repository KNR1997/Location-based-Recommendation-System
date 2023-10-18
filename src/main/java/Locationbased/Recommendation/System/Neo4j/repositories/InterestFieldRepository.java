package Locationbased.Recommendation.System.Neo4j.repositories;

import Locationbased.Recommendation.System.Neo4j.models.Interest;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.InterestFieldQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface InterestFieldRepository extends Neo4jRepository<Interest, Long> {
    @Query("MATCH (interest:Interest {name: $interestField})-[:HAS_SUBCATEGORY]->(subCategory:SubCategory) " +
            "RETURN subCategory as subCategory")
    List<InterestFieldQueryResult> getInterestFieldSubCategories(String interestField);
}
