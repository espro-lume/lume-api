package com.github.lume.api.api.repository;

import com.github.lume.api.api.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
