package Locationbased.Recommendation.System.Neo4j.repositories.neo4j;

import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface SubCategoryRepository extends Neo4jRepository<SubCategory, Long> {

    @Query("MATCH (s:SubCategory) WHERE s.status = 'Active' RETURN s")
    List<SubCategory> findAllActiveSubCategories();

    @Query("MATCH (place:Place)-[r:HAS_FEATURE]->(subCategory:SubCategory) " +
            "WHERE subCategory.name IN $subCategoryNames " +
            "return place")
    List<PlaceQueryResult> findPlacesContainsSubCategory(String[] subCategoryNames);
}
