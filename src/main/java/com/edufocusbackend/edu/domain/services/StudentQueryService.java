package com.edufocusbackend.edu.domain.services;
import com.edufocusbackend.edu.domain.model.aggregates.Student;
import com.edufocusbackend.edu.domain.model.queries.GetStudentByProfileIdQuery;
import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByProfileIdQuery query);
}
