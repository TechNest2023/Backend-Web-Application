package com.edubackend.edu.infraestructure.persistence.jpa.repositories;
import com.edubackend.edu.domain.model.aggregates.Reserve;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    List<Reserve> findAllByEduStudentRecordId(EduStudentRecordId eduStudentRecordId);
    List<Reserve> findAllBySpecialistId(Long specialistId);
    Optional<Reserve> findByEduStudentRecordIdAndSpecialistId(EduStudentRecordId eduStudentRecordId, Long specialistId);
}
