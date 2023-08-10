package com.github.kaydunovdenis.repository;

import com.github.kaydunovdenis.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
