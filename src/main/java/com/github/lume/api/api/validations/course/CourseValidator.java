package com.github.lume.api.api.validations.course;

import com.github.lume.api.api.dto.course.CourseRequestDTO;

public interface CourseValidator {
    void validateCourseCreation(CourseRequestDTO request);
}
