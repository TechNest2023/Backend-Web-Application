package com.edubackend.profiles.infraestructure.persistence.jpa.repositories;
import com.edubackend.edu.domain.model.aggregates.Student;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.profiles.domain.model.aggregates.Profile;
import com.edubackend.profiles.domain.model.commands.LoginStudentCommand;
import com.edubackend.profiles.domain.model.valueobjects.Email;
import com.edubackend.profiles.domain.model.valueobjects.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(Email emailAddress);
    Optional <Profile>findByEmailAndPassword(Email email, Password password);
}
