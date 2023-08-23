package Locationbased.Recommendation.System.Neo4j.objects;

import Locationbased.Recommendation.System.Neo4j.models.Lesson;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDTO {

    private String identifier;
    private String title;
    private String teacher;
    private List<Lesson> lessons = new ArrayList<>();

    public CourseDTO(String identifier, String title, String teacher) {
        this.identifier = identifier;
        this.title = title;
        this.teacher = teacher;
    }
}
