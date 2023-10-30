package com.edufocusbackend.edu.domain.services;

import com.edufocusbackend.edu.domain.model.commands.CreateSpecialistCommand;

public interface EspecialistCommandService {
    public long handle(CreateSpecialistCommand command);
}
