package Locationbased.Recommendation.System.Neo4j.queryResult;

import Locationbased.Recommendation.System.Neo4j.models.Course;
import Locationbased.Recommendation.System.Neo4j.models.User;
import lombok.Data;

@Data
public class CourseEnrolmentQueryResult {
    private User user;
    private Course course;

    public CourseEnrolmentQueryResult() {
    }
}
