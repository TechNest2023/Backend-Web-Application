package com.edubackend.profiles.interfaces.rest.transform;

import com.edubackend.profiles.domain.model.commands.CreateProfileCommand;
import com.edubackend.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource){
        return new CreateProfileCommand(resource.fullname(), resource.username(), resource.email(), resource.password());
    }
}
