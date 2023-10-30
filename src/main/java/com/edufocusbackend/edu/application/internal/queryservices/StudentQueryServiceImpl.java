package com.edufocusbackend.edu.application.internal.queryservices;

import com.edufocusbackend.edu.domain.model.aggregates.Student;
import com.edufocusbackend.edu.domain.model.commands.CreateStudentCommand;
import com.edufocusbackend.edu.domain.model.commands.UpdateStudentSessionOnActivityCompletedCommand;
import com.edufocusbackend.edu.domain.model.queries.GetStudentByProfileIdQuery;
import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;
import com.edufocusbackend.edu.domain.services.StudentCommandService;
import com.edufocusbackend.edu.domain.services.StudentQueryService;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {
    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(GetStudentByProfileIdQuery query){
        return studentRepository.findByProfileId(query.profileId());
    }

}
