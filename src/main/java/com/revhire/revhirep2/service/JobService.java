package com.revhire.revhirep2.service;

import com.revhire.revhirep2.entity.Job;
import java.util.List;

public interface JobService {

    Job createJob(Job job);

    Job updateJob(Long id, Job updatedData);

    void closeJob(Long jobId);

    void deactivateJob(Long jobId);

    List<Job> searchJobs(String location, Integer experience);

    List<Job> getJobsByEmployer(Long employerId);
}