package com.edubackend.edu.infraestructure.persistence.jpa.repositories;
import com.edubackend.edu.domain.model.aggregates.Specialist;
import com.edubackend.profiles.domain.model.valueobjects.PersonName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    Optional<Specialist> findByFullname(String fullname);
    boolean existsByFullname(String fullname);
    boolean existsByFullnameAndIdIsNot(String fullname, Long id);
}
