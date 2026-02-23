package com.revhire.revhirep2.service;

import com.revhire.revhirep2.entity.SavedJob;
import java.util.List;

public interface SavedJobService {

    SavedJob saveJob(SavedJob savedJob);

    void removeSavedJob(Long id);

    List<SavedJob> getSavedJobs(Long jobSeekerId);
}