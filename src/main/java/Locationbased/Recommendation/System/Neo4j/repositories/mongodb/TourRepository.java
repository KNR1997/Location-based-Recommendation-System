package Locationbased.Recommendation.System.Neo4j.repositories.mongodb;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourRepository extends MongoRepository<Tour, String> {

    Tour findByid(Integer id);
}
