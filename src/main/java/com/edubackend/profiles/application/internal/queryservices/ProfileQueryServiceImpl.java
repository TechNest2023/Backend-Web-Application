package com.edubackend.profiles.application.internal.queryservices;
import com.edubackend.profiles.domain.model.aggregates.Profile;
import com.edubackend.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.edubackend.profiles.domain.model.queries.GetProfileByIdQuery;
import com.edubackend.profiles.domain.services.ProfileQueryService;
import com.edubackend.profiles.infraestructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.emailAddress());
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }
}
