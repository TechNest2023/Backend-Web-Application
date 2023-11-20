package com.edubackend.iam.domain.services;
import com.edubackend.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
