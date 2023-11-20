package com.edubackend.profiles.interfaces.acl;
import com.edubackend.profiles.domain.model.commands.CreateProfileCommand;
import com.edubackend.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.edubackend.profiles.domain.model.valueobjects.Email;
import com.edubackend.profiles.domain.services.ProfileCommandService;
import com.edubackend.profiles.domain.services.ProfileQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProfilesContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacade(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    /**
     * Create a new Profile
     *
     * @param fullname
     * @param username
     * @param email
     * @param password
     * @return
     */
    public Long createProfile(String fullname, String username, String email, String password) {
        var createProfileCommand = new CreateProfileCommand(fullname, username, email, password);
        return profileCommandService.handle(createProfileCommand);
    }

    /**
     * Fetches the profile id by email
     * @param email the email
     * @return the profile id
     */
    public Long fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new Email(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }
}
