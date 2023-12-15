package Locationbased.Recommendation.System.Neo4j.repositories.neo4j;

import Locationbased.Recommendation.System.Neo4j.models.node.UserRecord;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRecordRepository extends Neo4jRepository<UserRecord, Long> {
}
