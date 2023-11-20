package com.edubackend.edu.domain.services;
import com.edubackend.edu.domain.model.aggregates.Student;
import com.edubackend.edu.domain.model.queries.GetStudentByEduStudentRecordIdQuery;
import com.edubackend.edu.domain.model.queries.GetStudentByProfileIdQuery;
import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByProfileIdQuery query);
    Optional<Student>handle(GetStudentByEduStudentRecordIdQuery query);
}
