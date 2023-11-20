package com.edubackend.profiles.domain.model.commands;

public record CreateProfileCommand(String fullname, String username, String email, String password) {
}
