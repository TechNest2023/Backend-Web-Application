package com.edubackend.edu.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Gender(@Column(name = "gender") String gender) {
    public Gender(){
        this(null);
    }

    public String getGender(){
        return gender;
    }
}
