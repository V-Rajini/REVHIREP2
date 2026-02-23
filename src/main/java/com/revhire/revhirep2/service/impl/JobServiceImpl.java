package com.revhire.revhirep2.service.impl;

import com.revhire.revhirep2.entity.Job;
import com.revhire.revhirep2.repository.JobRepository;
import com.revhire.revhirep2.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository repository;

    public JobServiceImpl(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public Job createJob(Job job) {
        job.setIsActive(true);
        return repository.save(job);
    }

    @Override
    public Job updateJob(Long id, Job updatedData) {
        Job existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        existing.setTitle(updatedData.getTitle());
        existing.setDescription(updatedData.getDescription());
        existing.setLocation(updatedData.getLocation());
        existing.setSalaryMin(updatedData.getSalaryMin());
        existing.setSalaryMax(updatedData.getSalaryMax());
        existing.setExperienceRequired(updatedData.getExperienceRequired());
        existing.setStatus(updatedData.getStatus());

        return repository.save(existing);
    }

    @Override
    public void closeJob(Long jobId) {
        Job job = repository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setStatus("CLOSED");
        repository.save(job);
    }

    @Override
    public void deactivateJob(Long jobId) {
        Job job = repository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setIsActive(false);
        repository.save(job);
    }

    @Override
    public List<Job> searchJobs(String location, Integer experience) {
        if (location != null && experience != null) {
            return repository.findByLocationContainingIgnoreCase(location);
        }
        return repository.findAll();
    }

    @Override
    public List<Job> getJobsByEmployer(Long employerId) {
        return repository.findAll()
                .stream()
                .filter(job -> job.getEmployer().getId().equals(employerId))
                .toList();
    }
}