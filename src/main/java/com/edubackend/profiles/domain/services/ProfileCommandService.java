package com.edubackend.profiles.domain.services;
import com.edubackend.profiles.domain.model.commands.CreateProfileCommand;

public interface ProfileCommandService {
    Long handle(CreateProfileCommand command);
}
