package Locationbased.Recommendation.System.Neo4j.services;

import Locationbased.Recommendation.System.Neo4j.models.Course;
import Locationbased.Recommendation.System.Neo4j.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
