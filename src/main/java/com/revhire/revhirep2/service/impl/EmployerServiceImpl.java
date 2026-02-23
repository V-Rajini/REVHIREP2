package com.revhire.revhirep2.service.impl;

import com.revhire.revhirep2.entity.Employer;
import com.revhire.revhirep2.repository.EmployerRepository;
import com.revhire.revhirep2.service.EmployerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository repository;

    public EmployerServiceImpl(EmployerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employer createCompany(Employer employer) {
        return repository.save(employer);
    }

    @Override
    public Employer updateCompany(Long id, Employer updatedData) {
        Employer existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        existing.setCompanyName(updatedData.getCompanyName());
        existing.setIndustry(updatedData.getIndustry());
        existing.setCompanySize(updatedData.getCompanySize());
        existing.setDescription(updatedData.getDescription());
        existing.setWebsite(updatedData.getWebsite());
        existing.setLocation(updatedData.getLocation());

        return repository.save(existing);
    }

    @Override
    public Optional<Employer> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}