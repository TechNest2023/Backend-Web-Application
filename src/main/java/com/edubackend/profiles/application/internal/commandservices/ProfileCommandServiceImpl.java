package com.edubackend.profiles.application.internal.commandservices;
import com.edubackend.edu.domain.model.aggregates.Student;
import com.edubackend.edu.domain.model.queries.GetStudentByEduStudentRecordIdQuery;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.edu.domain.model.valueobjects.ProfileId;
import com.edubackend.edu.infraestructure.persistence.jpa.repositories.StudentRepository;
import com.edubackend.edu.interfaces.rest.resources.LogInStudentResource;
import com.edubackend.edu.interfaces.rest.transform.LogInStudentCommandFromLogInStudentResourceAssembler;
import com.edubackend.profiles.domain.model.aggregates.Profile;
import com.edubackend.profiles.domain.model.commands.CreateProfileCommand;
import com.edubackend.profiles.domain.model.commands.LoginStudentCommand;
import com.edubackend.profiles.domain.model.valueobjects.Email;
import com.edubackend.profiles.domain.model.valueobjects.Password;
import com.edubackend.profiles.domain.services.ProfileCommandService;
import com.edubackend.profiles.infraestructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;
    private final StudentRepository studentRepository;
    public ProfileCommandServiceImpl(ProfileRepository profileRepository, StudentRepository studentRepository) {
        this.profileRepository = profileRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Long handle(CreateProfileCommand command) {
        var emailAddress = new Email(command.email());
        profileRepository.findByEmail(emailAddress).map(profile -> {
            throw new IllegalArgumentException("Profile with email " + command.email() + " already exists");
        });

        var profile = new Profile(command.fullname(), command.username(), command.email(), command.password());
        profileRepository.save(profile);
        return profile.getId();
    }

    @Override
    public EduStudentRecordId handle(LoginStudentCommand command) {
        var profile = profileRepository.findByEmailAndPassword(new Email(command.email()),new Password(command.password()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        var student = studentRepository.findByProfileId(new ProfileId(profile.getId()))
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return student.getEduStudentRecordId();
    }
}
