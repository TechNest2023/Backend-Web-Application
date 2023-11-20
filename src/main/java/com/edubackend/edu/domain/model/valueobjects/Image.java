package com.edubackend.edu.domain.model.valueobjects;
import jakarta.persistence.Embeddable;

@Embeddable
public record Image(String pathImage) {
    public Image(){
        this(null);
    }

    public Image{
        if (pathImage == null || pathImage.isBlank()){
            throw new IllegalArgumentException("Image cannot be null or blank");
        }
    }
}
