package com.edubackend.edu.domain.model.valueobjects;
import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record EduStudentRecordId(String studentRecordId) {
    public EduStudentRecordId(){
        this(UUID.randomUUID().toString());
    }

    public EduStudentRecordId{
        if (studentRecordId == null || studentRecordId.isBlank()){
            throw new IllegalArgumentException("Student record Id " +
                    "cannot be null or blank");
        }
    }
}
