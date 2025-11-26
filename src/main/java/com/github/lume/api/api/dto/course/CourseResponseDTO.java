package com.github.lume.api.api.dto.course;

import com.github.lume.api.api.dto.module.ModuleResponseDTO;

import java.util.List;

public record CourseResponseDTO(
        Integer id,
        String name,
        String description,
        Double evaluation,
        Integer workload,
        byte[] cover,
        List<ModuleResponseDTO> modules
) {}
