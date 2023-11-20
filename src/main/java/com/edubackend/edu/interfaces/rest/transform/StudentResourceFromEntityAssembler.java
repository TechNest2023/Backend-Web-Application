package com.edubackend.edu.interfaces.rest.transform;
import com.edubackend.edu.domain.model.aggregates.Student;
import com.edubackend.edu.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student student){
        return new StudentResource(
                student.getStudentRecordId(),
                student.getProfileId()
        );
    }
}
