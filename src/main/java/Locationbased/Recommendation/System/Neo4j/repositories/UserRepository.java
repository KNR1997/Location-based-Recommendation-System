package Locationbased.Recommendation.System.Neo4j.repositories;

import Locationbased.Recommendation.System.Neo4j.models.User;
import Locationbased.Recommendation.System.Neo4j.queryResult.*;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    @Query("MATCH (user:User {username: $userName}) RETURN user.username")
    String getUserName(String userName);

    @Query("MATCH (user:User), (course:Course) WHERE user.username = $username AND course.identifier = $identifier" +
            "RETURN EXISTS((user)-[:ENROLLED_IN]->(course))")
    Boolean findEnrolmentStatus(String username, String identifier);

    @Query("MATCH (user:User), (course:Course) WHERE user.username = $username AND course.identifier = $identifier " +
            "CREATE (user)-[:ENROLLED_IN]->(course) RETURN user, course")
    CourseEnrolmentQueryResult createEnrolmentRelationship(String username, String identifier);

    @Query("MATCH (user:User {username: $username})" +
            "WITH user, $interestFields AS userLikeFields " +
            "UNWIND userLikeFields AS field " +
            "MATCH (interestField:SubCategory {name: field})" +
            "CREATE (user)-[:LIKE]->(interestField) RETURN interestField.name AS fieldName,user")
    List<UserLikeQueryResult> createUserInterestedFieldsRelationship(String username, String[] interestFields);

    @Query("MATCH (:User {username: $userName})-[:LIKE]->(interestField:SubCategory) RETURN interestField AS likedField")
    List<UserLikedFieldsResult> getUserLikedInterestFields(String userName);

    @Query("MATCH (:User {username: $userName})-[:LIKE]->(subCategory:SubCategory) RETURN subCategory.name")
    List<String> getUserLikedSubCategories(String userName);

    @Query("MATCH (user:User) WHERE user.username = $username " +
            "RETURN EXISTS((user)-[:LIKE]->())")
    Boolean userAlreadyCreatedLikedFields(String username);

    @Query("MATCH (:User{username: $username})-[relationship:LIKE]->()" +
            "DELETE relationship")
    Void deleteAllUserLikedFields(String username);

    @Query("MATCH (user:User)-[:LIKE]->(subCategory:SubCategory) RETURN user.username AS userName, subCategory.name AS categoryName")
    List<UserNameAndLikedCategoriesQueryResult> getAllUsersWithLikeCategories();

    @Query("MATCH (user:User {username: $username})" +
            "MATCH (place:Place {name: $placeName})" +
            "CREATE (user)-[rating:RATE {rate: $rating}]->(place) RETURN user.username AS username, place.name AS placeName, rating.rate AS rating")
    UserRatePlaceQueryResult createUserRatePlaceRelationship(String username, String placeName, Integer rating);

    @Query("MATCH (user:User {username: $username})" +
            "WITH user, @similarUsers AS SimilarUsers " +
            "UNWIND SimilarUsers AS SimilarUser " +
            "MATCH (similarUser:User {username: SimilarUser})" +
            "CREATE (user)-[:SIMILAR_USER]->(similarUser) RETURN user.username AS userName,similarUser.username AS similarUser")
    Void createSimilarUsers(String username, String[] similarUsers);
}
