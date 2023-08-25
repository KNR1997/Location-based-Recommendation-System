package Locationbased.Recommendation.System.Neo4j.repositories;

import Locationbased.Recommendation.System.Neo4j.models.User;
import Locationbased.Recommendation.System.Neo4j.queryResult.CourseEnrolmentQueryResult;
import Locationbased.Recommendation.System.Neo4j.queryResult.UserLikeQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    @Query("MATCH (user:User), (course:Course) WHERE user.username = $username AND course.identifier = $identifier" +
            "RETURN EXISTS((user)-[:ENROLLED_IN]->(course))")
    Boolean findEnrolmentStatus(String username, String identifier);

    @Query("MATCH (user:User), (course:Course) WHERE user.username = $username AND course.identifier = $identifier " +
            "CREATE (user)-[:ENROLLED_IN]->(course) RETURN user, course")
    CourseEnrolmentQueryResult createEnrolmentRelationship(String username, String identifier);

    @Query("MATCH (user:User {username: $username})" +
            "WITH user, $interestFields AS userLikeFields " +
            "UNWIND userLikeFields AS field " +
            "MATCH (interestField:Interest {name: field})" +
            "CREATE (user)-[:LIKE]->(interestField) RETURN interestField.name AS fieldName,user")
    List<UserLikeQueryResult> createUserInterestedFieldsRelationship(String username, String[] interestFields);
}
