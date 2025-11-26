package com.github.lume.api.api.dto.module;

import com.github.lume.api.api.dto.lesson.LessonResponseDTO;

import java.util.List;

public record ModuleResponseDTO(
        Integer id,
        String title,
        List<LessonResponseDTO> lessons
) {}