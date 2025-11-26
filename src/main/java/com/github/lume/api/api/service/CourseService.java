package com.github.lume.api.api.service;

import com.github.lume.api.api.dto.course.CourseRequestDTO;
import com.github.lume.api.api.dto.course.CourseResponseDTO;
import com.github.lume.api.api.dto.lesson.LessonRequestDTO;
import com.github.lume.api.api.dto.lesson.LessonResponseDTO;
import com.github.lume.api.api.dto.module.ModuleRequestDTO;
import com.github.lume.api.api.dto.module.ModuleResponseDTO;
import com.github.lume.api.api.model.Course;
import com.github.lume.api.api.model.Lesson;
import com.github.lume.api.api.repository.CourseRepository;
import com.github.lume.api.api.repository.LessonRepository;
import com.github.lume.api.api.repository.ModuleRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import com.github.lume.api.api.model.Module;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    public CourseService(CourseRepository courseRepository,  ModuleRepository moduleRepository, LessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
    }

    public void create(CourseRequestDTO request) {

        Course course = new Course();
        course.setName(request.name());
        course.setDescription(request.description());
        course.setEvaluation(Double.parseDouble(request.evaluation()));
        course.setWorkload(Integer.parseInt(request.workload()));
        course.setCover(request.cover());

        List<Module> modules = new ArrayList<>();

        for (ModuleRequestDTO moduleDTO : request.modules()) {

            Module module = new Module();
            module.setTitle(moduleDTO.title());
            module.setCourse(course); // 🔥 FUNDAMENTAL

            List<Lesson> lessons = new ArrayList<>();

            for (LessonRequestDTO lessonDTO : moduleDTO.lessons()) {

                Lesson lesson = new Lesson();
                lesson.setName(lessonDTO.name());
                lesson.setDescription(lessonDTO.description());
                lesson.setUrl(lessonDTO.url());
                lesson.setFile(lessonDTO.file());
                lesson.setModule(module);

                lessons.add(lesson);
            }

            module.setLessons(lessons);
            modules.add(module);
        }

        course.setModules(modules);

        courseRepository.save(course);
    }

    public List<CourseResponseDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> new CourseResponseDTO(
                        course.getId(),
                        course.getName(),
                        course.getDescription(),
                        course.getEvaluation(),
                        course.getWorkload(),
                        course.getCover(),
                        course.getModules().stream()
                                .map(module -> new ModuleResponseDTO(
                                        module.getId(),
                                        module.getTitle(),
                                        module.getLessons().stream()
                                                .map(lesson -> new LessonResponseDTO(
                                                        lesson.getId(),
                                                        lesson.getName(),
                                                        lesson.getDescription(),
                                                        lesson.getUrl()
                                                )).toList()
                                )).toList()
                ))
                .toList();
    }
}
