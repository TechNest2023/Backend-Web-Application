package com.edubackend.profiles.domain.services;
import com.edubackend.profiles.domain.model.aggregates.Profile;
import com.edubackend.profiles.domain.model.queries.GetAllProfileQuery;
import com.edubackend.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.edubackend.profiles.domain.model.queries.GetProfileByIdQuery;
import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByEmailQuery query);

    Optional<Profile> handle(GetProfileByIdQuery query);

    List<Profile> handle(GetAllProfileQuery query);
}
