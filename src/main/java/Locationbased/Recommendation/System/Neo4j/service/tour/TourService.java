package Locationbased.Recommendation.System.Neo4j.service.tour;

import Locationbased.Recommendation.System.Neo4j.models.dto.TourDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Tour;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.TourRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.UserRecordRepository;
import Locationbased.Recommendation.System.Neo4j.service.tourCalculator.TourCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourCalculatorService tourCalculatorService;

    public TourDTO saveOrUpdateTour(TourDTO tourDTO) {
        Tour tour;
        int noOfTours = 0;
        boolean isNewTour = (tourDTO.getTourID() == null);
        UserRecord userRecord = this.userRecordRepository.findByid(tourDTO.getUserRecordID());
        if (userRecord.getTour() != null) {
            noOfTours = userRecord.getTour().size();
        }

        if (!isNewTour) {
            tour = this.tourRepository.findByid(tourDTO.getTourID());
        } else {
            tour = new Tour();

            tour.setId(noOfTours + 1);
            tour.setTourDays(tourDTO.getTourDays());
            tour.setCrew(tourDTO.getCrew());
            tour.setBudget(tourDTO.getBudget());
            tour.setDestination(tourDTO.getDestination());
            tour.setStartDate(tourDTO.getStartDate());
            tour.setEndDate(tourDTO.getEndDate());
        }

        this.tourCalculatorService.addRecommendedPlaces(userRecord, tour);

        return new TourDTO(tour);
    }
}
