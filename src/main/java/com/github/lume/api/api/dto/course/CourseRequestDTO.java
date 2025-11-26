package com.github.lume.api.api.dto.course;

import com.github.lume.api.api.dto.module.ModuleRequestDTO;

import java.util.List;

public record CourseRequestDTO (
        String name,
        String description,
        String evaluation,
        String workload,
        byte[] cover,
        List<ModuleRequestDTO> modules
) { }
