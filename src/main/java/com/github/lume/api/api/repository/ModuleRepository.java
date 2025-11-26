package com.github.lume.api.api.repository;

import com.github.lume.api.api.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
