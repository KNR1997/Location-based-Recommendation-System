package Locationbased.Recommendation.System.Neo4j.repositories.mongodb;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, String> {

    Rating findByid(String id);
}
