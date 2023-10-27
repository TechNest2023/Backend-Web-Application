package com.edufocus.edufocus.learning.domain.valueobject;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record StudentId(String studentId) {
    public StudentId(){
        this(UUID.randomUUID().toString());
    }
    public StudentId{
        if (studentId == null || studentId.isBlank()){
            throw new IllegalArgumentException("StudentId cannot be null or blank");
        }
    }
}
