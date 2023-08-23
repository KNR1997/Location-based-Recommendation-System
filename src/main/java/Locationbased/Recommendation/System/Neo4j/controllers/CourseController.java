package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.Course;
import Locationbased.Recommendation.System.Neo4j.objects.CourseDTO;
import Locationbased.Recommendation.System.Neo4j.services.CourseService;
import Locationbased.Recommendation.System.Neo4j.services.LessonService;
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

    private final LessonService lessonService;

    public CourseController(CourseService courseService, LessonService lessonService) {
        this.courseService = courseService;
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> courseIndex() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<CourseDTO> courseDetails(@PathVariable String identifier) {
        Course course = courseService.getCourseByIdentifier(identifier);

        CourseDTO responseCourse = new CourseDTO(course.getIdentifier(), course.getTitle(), course.getTeacher());
        responseCourse.setLessons(lessonService.getAllLessonsByCourseIdentifier(course.getIdentifier()));

        return new ResponseEntity<>(responseCourse, HttpStatus.OK);
    }
}
