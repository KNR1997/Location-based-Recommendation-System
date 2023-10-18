package Locationbased.Recommendation.System.Neo4j.dtos;

import Locationbased.Recommendation.System.Neo4j.models.Course;
import lombok.Data;

@Data
public class CourseEnrolmentDTO {
    private String name;
    private String username;
    private Course course;

    public CourseEnrolmentDTO() {
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
