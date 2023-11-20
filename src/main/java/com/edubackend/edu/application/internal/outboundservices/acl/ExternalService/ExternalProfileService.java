package com.edubackend.edu.application.internal.outboundservices.acl.ExternalService;
import com.edubackend.edu.domain.model.valueobjects.ProfileId;
import com.edubackend.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ExternalProfileService
 *
 * <p>
 *     This class is an outbound service used by the Edu Context to interact with the Profiles Context.
 *     It is implemented as part of an anti-corruption layer (ACL) to decouple the Edu Context from the Profiles Context.
 * </p>
 *
 */

@Service
public class ExternalProfileService {
    private final ProfilesContextFacade profilesContextFacade;


    public ExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    /**
     * Fetch profileId by email
     *
     * @param email the email to search for
     * @return profileId if found, empty otherwise
     */
    public Optional<ProfileId> fetchProfileIdByEmail(String email) {
        var profileId = profilesContextFacade.fetchProfileIdByEmail(email);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

    public Optional<ProfileId> createProfile(String fullname, String username, String email, String password) {
        var profileId = profilesContextFacade.createProfile(fullname, username, email, password);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }
}
