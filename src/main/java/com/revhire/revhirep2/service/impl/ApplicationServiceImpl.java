package com.revhire.revhirep2.service.impl;

import com.revhire.revhirep2.entity.Application;
import com.revhire.revhirep2.repository.ApplicationRepository;
import com.revhire.revhirep2.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository repository;

    public ApplicationServiceImpl(ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Application applyToJob(Application application) {

        boolean alreadyApplied = repository
                .findByJobIdAndJobSeekerId(
                        application.getJob().getId(),
                        application.getJobSeeker().getId())
                .isPresent();

        if (alreadyApplied) {
            throw new RuntimeException("You have already applied to this job");
        }

        application.setStatus("APPLIED");
        application.setAppliedAt(LocalDateTime.now());
        application.setUpdatedAt(LocalDateTime.now());

        return repository.save(application);
    }

    @Override
    public void withdrawApplication(Long applicationId) {
        Application application = repository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        application.setStatus("WITHDRAWN");
        application.setUpdatedAt(LocalDateTime.now());

        repository.save(application);
    }

    @Override
    public void updateStatus(Long applicationId, String status) {
        Application application = repository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        application.setStatus(status);
        application.setUpdatedAt(LocalDateTime.now());

        repository.save(application);
    }

    @Override
    public List<Application> getApplicationsByJob(Long jobId) {
        return repository.findByJobId(jobId);
    }

    @Override
    public List<Application> getApplicationsByJobSeeker(Long jobSeekerId) {
        return repository.findByJobSeekerId(jobSeekerId);
    }
}