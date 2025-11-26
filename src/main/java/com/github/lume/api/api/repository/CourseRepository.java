package com.github.lume.api.api.repository;

import com.github.lume.api.api.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
