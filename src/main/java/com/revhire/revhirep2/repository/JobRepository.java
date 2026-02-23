package com.revhire.revhirep2.repository;

import com.revhire.revhirep2.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByLocationContainingIgnoreCase(String location);

    List<Job> findByExperienceRequiredGreaterThanEqual(Integer experience);

    List<Job> findByStatus(String status);
}