package com.revhire.revhirep2.service;

import com.revhire.revhirep2.entity.*;

public interface ResumeService {

    Resume createResume(Resume resume);

    Resume updateObjective(Long resumeId, String objective);

    Education addEducation(Long resumeId, Education education);

    Experience addExperience(Long resumeId, Experience experience);

    Skill addSkill(Long resumeId, Skill skill);

    Certification addCertification(Long resumeId, Certification certification);

    void deleteEducation(Long educationId);

    void deleteExperience(Long experienceId);

    void deleteSkill(Long skillId);

    void deleteCertification(Long certificationId);

    Resume getResumeByJobSeeker(Long jobSeekerId);
}