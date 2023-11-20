package com.edubackend.edu.infraestructure.persistence.jpa.repositories;
import com.edubackend.edu.domain.model.aggregates.Student;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.edu.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student>findByEduStudentRecordId(EduStudentRecordId eduStudentRecordId);
    Optional<Student> findByProfileId(ProfileId profileId);
}
