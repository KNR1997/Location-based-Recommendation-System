package Locationbased.Recommendation.System.Neo4j.repositories.neo4j;

import Locationbased.Recommendation.System.Neo4j.models.node.UserRecordNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRecordNodeRepository extends Neo4jRepository<UserRecordNode, Long> {

//    Optional<UserRecord> findUserRecordByUserID(Long userID);

    UserRecordNode findUserRecordByID(Long userRecordID);
}
