package Locationbased.Recommendation.System.Neo4j.service.tourCalculator;

import Locationbased.Recommendation.System.Neo4j.algorithm.ContentBasedFiltering;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Tour;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.models.node.Province;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.UserRecordRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TourCalculatorService {

    @Autowired
    private ContentBasedFiltering contentBasedFiltering;

    @Autowired
    private UserRecordRepository userRecordRepository;

    public void addRecommendedPlaces(UserRecord userRecord, Tour tour) {

        String[] likeSubCategories = userRecord.getLikeSubCategories();
        String location = tour.getDestination();
        String[] places = this.contentBasedFiltering.contentBasedRecommendedPlaces(likeSubCategories, location);
        tour.setRecommendedPlaces(places);

        userRecord.getTour().add(tour);
        this.userRecordRepository.save(userRecord);
    }
}

