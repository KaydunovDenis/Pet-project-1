package com.github.kaydunovdenis.service;

import com.github.kaydunovdenis.model.Employee;
import com.github.kaydunovdenis.model.Project;
import com.github.kaydunovdenis.model.Report;
import com.github.kaydunovdenis.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final ReportRepository reportRepository;

    @Transactional
    public Report save(Project project, Employee employee, String description) {
        return reportRepository.save(new Report(project, employee, description));
    }

}
