package com.revhire.revhirep2.repository;

import com.revhire.revhirep2.entity.SavedJob;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SavedJobRepository extends JpaRepository<SavedJob, Long> {

    List<SavedJob> findByJobSeekerId(Long jobSeekerId);
}