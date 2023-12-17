package Locationbased.Recommendation.System.Neo4j.models.mongoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tour")
public class Tour {

    private String id;

    private String destination;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer tourDays;

    private Integer budget;

    private Integer crew;
}
