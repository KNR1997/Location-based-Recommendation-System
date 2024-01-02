package Locationbased.Recommendation.System.Neo4j.repositories.mongodb;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRecordRepository extends MongoRepository<UserRecord, String> {

    UserRecord findByid(String id);

    UserRecord findByUserID(Long userID);

    List<UserRecord> findTop1ByUserIDOrderByTimeStampDesc(Long userID);

    boolean existsByUserID(Long userID);
}
