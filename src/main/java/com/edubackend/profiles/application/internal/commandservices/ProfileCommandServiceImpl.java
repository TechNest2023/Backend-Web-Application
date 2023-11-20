package com.edubackend.profiles.application.internal.commandservices;
import com.edubackend.profiles.domain.model.aggregates.Profile;
import com.edubackend.profiles.domain.model.commands.CreateProfileCommand;
import com.edubackend.profiles.domain.model.valueobjects.Email;
import com.edubackend.profiles.domain.services.ProfileCommandService;
import com.edubackend.profiles.infraestructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
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
}
