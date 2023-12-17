package Locationbased.Recommendation.System.Neo4j.models.dto;

import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Tour;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TourDTO {

    private Integer tourID;

    private String userRecordID;

    private String destination;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer tourDays;

    private Integer budget;

    private Integer crew;

    public TourDTO() {
    }

    public TourDTO(Tour tour) {
        this.tourID = tour.getId();
        this.destination = tour.getDestination();
        this.startDate = tour.getStartDate();
        this.endDate = tour.getEndDate();
        this.tourDays = tour.getTourDays();
        this.budget = tour.getBudget();
        this.crew = tour.getCrew();
    }
}
