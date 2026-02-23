package com.revhire.revhirep2.service;

import com.revhire.revhirep2.entity.Application;
import java.util.List;

public interface ApplicationService {

    Application applyToJob(Application application);

    void withdrawApplication(Long applicationId);

    void updateStatus(Long applicationId, String status);

    List<Application> getApplicationsByJob(Long jobId);

    List<Application> getApplicationsByJobSeeker(Long jobSeekerId);
}