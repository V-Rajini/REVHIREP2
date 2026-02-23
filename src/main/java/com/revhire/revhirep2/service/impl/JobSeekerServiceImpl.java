package com.revhire.revhirep2.service.impl;

import com.revhire.revhirep2.entity.JobSeeker;
import com.revhire.revhirep2.repository.JobSeekerRepository;
import com.revhire.revhirep2.service.JobSeekerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    private final JobSeekerRepository repository;

    public JobSeekerServiceImpl(JobSeekerRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobSeeker createProfile(JobSeeker jobSeeker) {
        return repository.save(jobSeeker);
    }

    @Override
    public JobSeeker updateProfile(Long id, JobSeeker updatedData) {
        JobSeeker existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        existing.setFullName(updatedData.getFullName());
        existing.setPhone(updatedData.getPhone());
        existing.setLocation(updatedData.getLocation());
        existing.setEmploymentStatus(updatedData.getEmploymentStatus());
        existing.setProfileSummary(updatedData.getProfileSummary());

        return repository.save(existing);
    }

    @Override
    public Optional<JobSeeker> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}