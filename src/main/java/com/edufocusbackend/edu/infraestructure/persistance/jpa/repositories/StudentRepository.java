package com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories;

import com.edufocusbackend.edu.domain.model.aggregates.Student;
import com.edufocusbackend.edu.domain.model.valueobjects.ProfileId;
import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentRecordId(StudentRecordId studentRecordId);
    Optional<Student> findByProfileId(ProfileId profileId);
}
