package com.edubackend.edu.domain.model.valueobjects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Date;

@Embeddable
public record Birthdate(@Column(name = "birthdate") String birthdate) {
    public Birthdate(){
        this(null);
    }

    public String getBirthdate(){
        return birthdate;
    }
}
