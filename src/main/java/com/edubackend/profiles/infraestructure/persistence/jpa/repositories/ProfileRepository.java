package com.edubackend.profiles.infraestructure.persistence.jpa.repositories;
import com.edubackend.profiles.domain.model.aggregates.Profile;
import com.edubackend.profiles.domain.model.valueobjects.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(Email emailAddress);
}
