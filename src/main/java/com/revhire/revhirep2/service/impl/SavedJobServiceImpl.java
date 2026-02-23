package com.revhire.revhirep2.service.impl;

import com.revhire.revhirep2.entity.SavedJob;
import com.revhire.revhirep2.repository.SavedJobRepository;
import com.revhire.revhirep2.service.SavedJobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedJobServiceImpl implements SavedJobService {

    private final SavedJobRepository repository;

    public SavedJobServiceImpl(SavedJobRepository repository) {
        this.repository = repository;
    }

    @Override
    public SavedJob saveJob(SavedJob savedJob) {
        return repository.save(savedJob);
    }

    @Override
    public void removeSavedJob(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<SavedJob> getSavedJobs(Long jobSeekerId) {
        return repository.findAll()
                .stream()
                .filter(s -> s.getJobSeeker().getId().equals(jobSeekerId))
                .toList();
    }
}