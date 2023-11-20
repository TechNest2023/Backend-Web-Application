package com.edubackend.profiles.domain.model.valueobjects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName(@Column(name = "fullname") String personName) {
    public PersonName(){
        this(null);
    }

    public PersonName{
        if (personName == null || personName.isBlank()){
            throw new IllegalArgumentException("PersonName cannot be null or blank");
        }
    }

    public String getFullName(){
        return personName;
    }
}
