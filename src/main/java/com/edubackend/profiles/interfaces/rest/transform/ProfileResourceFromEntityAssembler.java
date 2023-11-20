package com.edubackend.profiles.interfaces.rest.transform;
import com.edubackend.profiles.domain.model.aggregates.Profile;
import com.edubackend.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile profile) {
        return new ProfileResource(profile.getId(), profile.getFullName(),
                profile.getUserName(), profile.getEmailAddress());
    }
}
