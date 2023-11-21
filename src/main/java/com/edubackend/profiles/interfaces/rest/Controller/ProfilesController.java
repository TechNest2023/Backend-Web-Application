package com.edubackend.profiles.interfaces.rest.Controller;
import com.edubackend.edu.domain.model.queries.GetStudentByEduStudentRecordIdQuery;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.edu.interfaces.rest.resources.LogInStudentResource;
import com.edubackend.edu.interfaces.rest.transform.LogInStudentCommandFromLogInStudentResourceAssembler;
import com.edubackend.profiles.domain.model.queries.GetProfileByIdQuery;
import com.edubackend.profiles.domain.services.ProfileCommandService;
import com.edubackend.profiles.domain.services.ProfileQueryService;
import com.edubackend.profiles.interfaces.rest.resources.CreateProfileResource;
import com.edubackend.profiles.interfaces.rest.resources.ProfileResource;
import com.edubackend.profiles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.edubackend.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ProfilesController
 *
 * <p> Controller that handles the endpoint for profiles.
 *     It uses{@link ProfileCommandService} an {@link ProfileResource}
 *     to handle the commands y queries for profiles
 *     <ul>
 *         <li>POST /api/v1/profiles</li>
 *         <li>GET /api/v1/profiles/{profileId}</li>
 *     </ul>
 * </p>
 */

@RestController
@RequestMapping(value = "/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Profile Management Endpoints")
public class ProfilesController {

    private final ProfileQueryService profileQueryService;
    private final ProfileCommandService profileCommandService;

    public ProfilesController(ProfileQueryService profileQueryService, ProfileCommandService profileCommandService) {
        this.profileQueryService = profileQueryService;
        this.profileCommandService = profileCommandService;
    }

    /**
     * POST /api/v1/profiles
     *
     * <p>Endpoint that creates a profile</p>
     * @param resource the resource with the information to create the profile
     * @return the created profile
     * @see CreateProfileResource
     * @see ProfileResource
     */
    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(CreateProfileResource resource) {

        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profileId = profileCommandService.handle(createProfileCommand);
        if (profileId == 0L) {
            return ResponseEntity.badRequest().build();
        }

        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) {
            return  ResponseEntity.badRequest().build();
        }

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);

    }

    /**
     * GET /api/vq/profiles/{profileID}
     * <p>Endpoint that returns a profile</p>
     * @param profileId the id the profile  to be returned
     * @return the profile resource for the given id
     * @see ProfileResource
     */
    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }
    @PostMapping("/login")
    public ResponseEntity<EduStudentRecordId> loginStudent(@RequestBody LogInStudentResource resource) {

        var loginStudentCommand = LogInStudentCommandFromLogInStudentResourceAssembler.toCommand(resource);
        var studentId = profileCommandService.handle(loginStudentCommand);
        if (studentId.studentRecordId().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(studentId, HttpStatus.OK);
    }
}
