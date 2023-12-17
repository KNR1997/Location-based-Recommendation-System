package Locationbased.Recommendation.System.Neo4j.repositories.mongodb;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRecordRepository extends MongoRepository<UserRecord, String> {

    UserRecord findByid(String id);

    UserRecord findByUserID(Long userID);
}
