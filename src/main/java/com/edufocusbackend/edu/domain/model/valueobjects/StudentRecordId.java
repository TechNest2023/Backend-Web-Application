package com.edufocusbackend.edu.domain.model.valueobjects;
import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record StudentRecordId (String studentRecordId) {
    public StudentRecordId(){
        this(UUID.randomUUID().toString());
    }

    public StudentRecordId{
        if (studentRecordId == null || studentRecordId.isBlank()){
            throw new IllegalArgumentException("Student record profileId " +
                    "cannot be null or blank");
        }
    }
}
