package Locationbased.Recommendation.System.Neo4j.repositories.mongodb;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRecordRepository extends MongoRepository<UserRecord, String> {

    UserRecord findByid(String id);

    UserRecord findByUserID(Long userID);

    @Query("{'userID': ?0}")
    UserRecord findLatestUserRecord(Long userID);
}
