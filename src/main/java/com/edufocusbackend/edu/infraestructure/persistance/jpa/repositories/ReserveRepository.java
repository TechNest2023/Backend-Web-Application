package com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories;
import com.edufocusbackend.edu.domain.model.aggregates.Reserve;
import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    List<Reserve> findAllByStudentRecordId(StudentRecordId studentRecordId);
}
