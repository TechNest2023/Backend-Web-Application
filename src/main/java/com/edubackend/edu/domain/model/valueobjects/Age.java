package com.edubackend.edu.domain.model.valueobjects;
import jakarta.persistence.Embeddable;

@Embeddable
public record Age(Integer age) {
    public Age(){
        this(null);
    }

    public Age{
        if (age < 25 || age > 35){
            throw new IllegalArgumentException("The age must be between 25 and 35 years");
        }
    }

    public Integer getAge(){return age;}
}
