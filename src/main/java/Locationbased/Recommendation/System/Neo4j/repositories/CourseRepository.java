package Locationbased.Recommendation.System.Neo4j.repositories;

import Locationbased.Recommendation.System.Neo4j.models.Course;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CourseRepository extends Neo4jRepository<Course, Long> {
}
