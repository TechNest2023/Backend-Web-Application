package com.edufocus.edufocus.learning.domain.valueobject;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record EspecialistId(String especialistId) {
    public EspecialistId(){
        this(UUID.randomUUID().toString());
    }
    public EspecialistId{
        if (especialistId == null || especialistId.isBlank()){
            throw new IllegalArgumentException("EspecialistId cannot be null or blank");
        }
    }
}
