package Locationbased.Recommendation.System.Neo4j.models.mongoEntity;

import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userRecord")
@CompoundIndexes({
        @CompoundIndex(name = "user_timestamp", def = "{'userID': 1, 'timeStamp': -1}")
})
public class UserRecord {

    @Id
    private String id;

    private Long userID;

    private List<SubCategory> likeSubCategories;

    private List<Tour> tour;

    @CreatedDate
    private LocalDateTime timeStamp;

}
