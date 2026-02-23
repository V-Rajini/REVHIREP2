package com.revhire.revhirep2.service.impl;

import com.revhire.revhirep2.entity.*;
import com.revhire.revhirep2.repository.ResumeRepository;
import com.revhire.revhirep2.service.ResumeService;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository repository;

    public ResumeServiceImpl(ResumeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Resume createResume(Resume resume) {
        return repository.save(resume);
    }

    @Override
    public Resume updateObjective(Long resumeId, String objective) {
        Resume resume = repository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        resume.setObjective(objective);
        return repository.save(resume);
    }

    @Override
    public Education addEducation(Long resumeId, Education education) {
        Resume resume = repository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        education.setResume(resume);
        resume.getEducationList().add(education);

        repository.save(resume);
        return education;
    }

    @Override
    public Experience addExperience(Long resumeId, Experience experience) {
        Resume resume = repository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        experience.setResume(resume);
        resume.getExperienceList().add(experience);

        repository.save(resume);
        return experience;
    }

    @Override
    public Skill addSkill(Long resumeId, Skill skill) {
        Resume resume = repository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        skill.setResume(resume);
        resume.getSkills().add(skill);

        repository.save(resume);
        return skill;
    }

    @Override
    public Certification addCertification(Long resumeId, Certification certification) {
        Resume resume = repository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        certification.setResume(resume);
        resume.getCertifications().add(certification);

        repository.save(resume);
        return certification;
    }

    @Override
    public void deleteEducation(Long educationId) {
        throw new RuntimeException("Use cascade remove via resume for now");
    }

    @Override
    public void deleteExperience(Long experienceId) {
        throw new RuntimeException("Use cascade remove via resume for now");
    }

    @Override
    public void deleteSkill(Long skillId) {
        throw new RuntimeException("Use cascade remove via resume for now");
    }

    @Override
    public void deleteCertification(Long certificationId) {
        throw new RuntimeException("Use cascade remove via resume for now");
    }

    @Override
    public Resume getResumeByJobSeeker(Long jobSeekerId) {
        return repository.findByJobSeekerId(jobSeekerId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));
    }
}