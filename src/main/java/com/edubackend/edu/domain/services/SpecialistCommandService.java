package com.edubackend.edu.domain.services;

import com.edubackend.edu.domain.model.commands.CreateSpecialistCommand;

public interface SpecialistCommandService {

    Long handle(CreateSpecialistCommand command);

}
