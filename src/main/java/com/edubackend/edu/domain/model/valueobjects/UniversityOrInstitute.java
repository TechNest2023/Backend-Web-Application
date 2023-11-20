package com.edubackend.edu.domain.model.valueobjects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record UniversityOrInstitute(@Column(name = "institution") String universityOrInstitute) {
    public UniversityOrInstitute(){
        this(null);
    }

    public String getUniversityOrInstitute(){
        return universityOrInstitute;
    }
}