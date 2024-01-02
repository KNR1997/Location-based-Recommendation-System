package Locationbased.Recommendation.System.Neo4j.repositories.mongodb;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends MongoRepository<Place, String> {

    Place findByid(String id);

    List<Place> findByCity(String city);

    @Query("{title: ?0}")
    List<Place> findByTitle(String title);

    @Query("{placeCategory: ?0}")
    Page<Place> findByPlaceCategory(String placeCategory, Pageable pageable);

    @Query("{ 'featured' : true }")
    List<Place> findFeaturedPlaces();
}
