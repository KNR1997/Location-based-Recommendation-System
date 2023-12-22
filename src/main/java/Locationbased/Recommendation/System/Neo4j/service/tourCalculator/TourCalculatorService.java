package Locationbased.Recommendation.System.Neo4j.service.tourCalculator;

import Locationbased.Recommendation.System.Neo4j.algorithm.CollaborativeFiltering;
import Locationbased.Recommendation.System.Neo4j.algorithm.ContentBasedFiltering;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Tour;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourCalculatorService {

    @Autowired
    private ContentBasedFiltering contentBasedFiltering;

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Autowired
    private CollaborativeFiltering collaborativeFiltering;

    @Async
    public void addRecommendedPlaces(UserRecord userRecord, Tour tour) {

        List<SubCategory> likeSubCategories = userRecord.getLikeSubCategories();
        String location = tour.getDestination();
        String[] places = this.contentBasedFiltering.contentBasedRecommendedPlaces(likeSubCategories, location);
        tour.setRecommendedPlaces(places);
        String[] ratedPlaces = this.collaborativeFiltering.collaborativeFilteringRecommendedPlaces(location);
        tour.setRatedPlaces(ratedPlaces);

        userRecord.getTour().add(tour);
        this.userRecordRepository.save(userRecord);
    }
}

