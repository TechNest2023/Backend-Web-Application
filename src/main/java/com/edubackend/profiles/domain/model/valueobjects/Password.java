package com.edubackend.profiles.domain.model.valueobjects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Password(@Column(name = "password") String password) {
    public Password(){
        this(null);
    }

    public Password{
        if (password == null || password.isBlank()){
            throw new IllegalArgumentException("Password cannot be null or blank");
        }
    }
}

