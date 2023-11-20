package com.edubackend.edu.application.internal.queryservices;

import com.edubackend.edu.domain.model.aggregates.Student;
import com.edubackend.edu.domain.model.queries.GetStudentByEduStudentRecordIdQuery;
import com.edubackend.edu.domain.model.queries.GetStudentByProfileIdQuery;
import com.edubackend.edu.domain.services.StudentQueryService;
import com.edubackend.edu.infraestructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of StudentQueryService
 *
 * <p>
 *     This class is the implementation of the StudentQueryService interface.
 *     It is used by the EduContext to handle queries on the Student aggregate.
 * </p>
 *
 */

@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Query handler to get student by profileId
     *
     * @param query containing profileId
     * @return Student
     */
    @Override
    public Optional<Student> handle(GetStudentByProfileIdQuery query) {
        return studentRepository.findByProfileId(query.profileId());
    }

    @Override
    public Optional<Student> handle(GetStudentByEduStudentRecordIdQuery query) {
        return studentRepository.findByEduStudentRecordId(query.eduStudentRecordId());
    }
}
