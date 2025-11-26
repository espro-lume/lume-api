package com.github.lume.api.api.dto.course;

public record CourseRequestDTO (String name, String description, String evaluation, String workload, byte[] cover) {

}
