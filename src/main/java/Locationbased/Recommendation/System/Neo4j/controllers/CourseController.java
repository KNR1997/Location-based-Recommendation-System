package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.Course;
import Locationbased.Recommendation.System.Neo4j.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> courseIndex() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Course> courseDetails(@PathVariable String identifier) {
        Course course = courseService.getCourseByIdentifier(identifier);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
