package com.edubackend.edu.interfaces.rest.transform;

import com.edubackend.profiles.domain.model.commands.LoginStudentCommand;
import com.edubackend.edu.interfaces.rest.resources.LogInStudentResource;

public class LogInStudentCommandFromLogInStudentResourceAssembler {
    public static LoginStudentCommand toCommand(LogInStudentResource resource) {
        return new LoginStudentCommand(resource.email(), resource.password());
    }
}
