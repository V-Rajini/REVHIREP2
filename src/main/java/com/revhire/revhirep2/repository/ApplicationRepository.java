package com.revhire.revhirep2.repository;

import com.revhire.revhirep2.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByJobId(Long jobId);

    List<Application> findByJobSeekerId(Long jobSeekerId);

    Optional<Application> findByJobIdAndJobSeekerId(Long jobId, Long jobSeekerId);
}