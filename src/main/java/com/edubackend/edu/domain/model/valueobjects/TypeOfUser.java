package com.edubackend.edu.domain.model.valueobjects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
@Embeddable
public record TypeOfUser(@Column(name = "type") String typeOfUser) {
    public TypeOfUser(){
        this(null);
    }

    public TypeOfUser{
        if (typeOfUser == null || typeOfUser.isBlank()){
            throw new IllegalArgumentException("TypeOfUser cannot be null or blank");
        }
    }

    public String getTypeOfUser(){
        return typeOfUser;
    }
}