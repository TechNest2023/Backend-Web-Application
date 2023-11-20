package com.edubackend.profiles.domain.model.valueobjects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record UserName(@Column(name = "username") String username) {
    public UserName(){
        this(null);
    }

    public UserName{
        if (username == null || username.isBlank()){
            throw new IllegalArgumentException("UserName cannot be null or blank");
        }
    }

    public String getUserName(){
        return username;
    }
}