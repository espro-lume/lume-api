package com.github.lume.api.api.dto.lesson;

public record LessonResponseDTO(
        Integer id,
        String name,
        String description,
        String url
) {}