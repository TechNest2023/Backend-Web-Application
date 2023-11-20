package com.edubackend.edu.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Career(String career) {
    public Career(){
        this(null);
    }

    public Career{
        if (career == null || career.isBlank()){
            throw new IllegalArgumentException("Career cannot be null or blank");
        }
    }

    public String getCareer(){
        return career;
    }
}
