package com.github.lume.api.api.dto.module;

import com.github.lume.api.api.dto.lesson.LessonRequestDTO;
import java.util.List;

public record ModuleRequestDTO (String title, List<LessonRequestDTO> lessons)  { }
