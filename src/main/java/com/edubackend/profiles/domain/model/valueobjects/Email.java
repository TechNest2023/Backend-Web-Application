package com.edubackend.profiles.domain.model.valueobjects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Email(
        @Column(name = "email")
        @jakarta.validation.constraints.Email
        String address)
{

    public Email(){
        this(null);
    }

    public Email{
        if (address == null || address.isBlank()){
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
    }
}
