package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.Course;
import Locationbased.Recommendation.System.Neo4j.dtos.CourseDTO;
import Locationbased.Recommendation.System.Neo4j.services.CourseEnrolmentService;
import Locationbased.Recommendation.System.Neo4j.services.CourseService;
import Locationbased.Recommendation.System.Neo4j.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    private final LessonService lessonService;

    private final CourseEnrolmentService courseEnrolmentService;

    @Autowired
    public CourseController(CourseService courseService, LessonService lessonService, CourseEnrolmentService courseEnrolmentService) {
        this.courseService = courseService;
        this.lessonService = lessonService;
        this.courseEnrolmentService = courseEnrolmentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> courseIndex() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<CourseDTO> courseDetails(@PathVariable String identifier, Principal principal) {
        Course course = courseService.getCourseByIdentifier(identifier);

        CourseDTO responseCourse = new CourseDTO();

        responseCourse.setIdentifier(course.getIdentifier());
        responseCourse.setTitle(course.getTitle());
        responseCourse.setTeacher(course.getTeacher());
        responseCourse.setLessons(lessonService.getAllLessonsByCourseIdentifier(identifier));

        if (principal != null)
            responseCourse.setEnrolled(courseEnrolmentService.getEnrolmentStatus(principal.getName(), identifier));

        return new ResponseEntity<>(responseCourse, HttpStatus.OK);
    }
}
