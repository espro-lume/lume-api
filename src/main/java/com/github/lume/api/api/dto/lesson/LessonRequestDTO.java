package com.github.lume.api.api.dto.lesson;

import jakarta.annotation.Nullable;

public record LessonRequestDTO (
        String name,
        String description,
        @Nullable String url,
        @Nullable byte[] file
) {}
