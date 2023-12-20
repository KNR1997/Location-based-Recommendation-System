package Locationbased.Recommendation.System.Neo4j.repositories.mongodb;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlaceRepository extends MongoRepository<Place, String> {

    Place findByid(String id);

    List<Place> findByCity(String city);

    @Query("{title: ?0}")
    List<Place> findByTitle(String title);
}
