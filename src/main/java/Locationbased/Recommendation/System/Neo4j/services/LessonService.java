package Locationbased.Recommendation.System.Neo4j.services;

import Locationbased.Recommendation.System.Neo4j.models.Lesson;
import Locationbased.Recommendation.System.Neo4j.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLessonsByCourseIdentifier(String identifier) {
        return lessonRepository.findLessonsByCourseIdentifier(identifier);
    }
}
