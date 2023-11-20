package com.edubackend.iam.domain.model.commands;
import com.edubackend.iam.domain.model.valueobjects.Roles;
import java.util.List;

public record SignUpCommand(String username, String password, List<Roles> roles) {
}
