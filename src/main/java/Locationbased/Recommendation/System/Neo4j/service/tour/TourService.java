package Locationbased.Recommendation.System.Neo4j.service.tour;

import Locationbased.Recommendation.System.Neo4j.models.dto.TourDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Tour;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.TourRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Autowired
    private TourRepository tourRepository;

    public TourDTO saveOrUpdateTour(TourDTO tourDTO) {
        Tour tour;
        boolean isNewTour = (tourDTO.getTourID() == null);
        UserRecord userRecord = this.userRecordRepository.findByid(tourDTO.getUserRecordID());

        if (!isNewTour) {
            tour = this.tourRepository.findByid(tourDTO.getTourID());
        } else {
            tour = new Tour();

            tour.setTourDays(tourDTO.getTourDays());
            tour.setCrew(tourDTO.getCrew());
            tour.setBudget(tourDTO.getBudget());
            tour.setDestination(tourDTO.getDestination());
            tour.setStartDate(tourDTO.getStartDate());
            tour.setEndDate(tourDTO.getEndDate());
        }

        userRecord.getTour().add(tour);
        this.userRecordRepository.save(userRecord);
        return new TourDTO(tour);
    }
}
