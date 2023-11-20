package com.edubackend.profiles.domain.services;
import com.edubackend.profiles.domain.model.aggregates.Profile;
import com.edubackend.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.edubackend.profiles.domain.model.queries.GetProfileByIdQuery;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByEmailQuery query);

    Optional<Profile> handle(GetProfileByIdQuery query);
}
