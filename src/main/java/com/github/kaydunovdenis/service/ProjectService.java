package com.github.kaydunovdenis.service;

import com.github.kaydunovdenis.model.Project;
import com.github.kaydunovdenis.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project getProject(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Project"));
    }
}
