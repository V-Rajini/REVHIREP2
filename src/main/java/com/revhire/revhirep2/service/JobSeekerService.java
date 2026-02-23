package com.revhire.revhirep2.service;

import com.revhire.revhirep2.entity.JobSeeker;
import java.util.Optional;

public interface JobSeekerService {

    JobSeeker createProfile(JobSeeker jobSeeker);

    JobSeeker updateProfile(Long id, JobSeeker updatedData);

    Optional<JobSeeker> getByUserId(Long userId);
}