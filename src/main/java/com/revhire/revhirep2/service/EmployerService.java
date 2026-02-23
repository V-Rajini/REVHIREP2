package com.revhire.revhirep2.service;

import com.revhire.revhirep2.entity.Employer;
import java.util.Optional;

public interface EmployerService {

    Employer createCompany(Employer employer);

    Employer updateCompany(Long id, Employer updatedData);

    Optional<Employer> getByUserId(Long userId);
}