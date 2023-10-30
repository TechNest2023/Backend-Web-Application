package com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories;
import com.edufocusbackend.edu.domain.model.aggregates.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistRepository  extends JpaRepository<Specialist, Long> {
}
