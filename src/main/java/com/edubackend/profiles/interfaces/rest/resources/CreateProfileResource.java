package com.edubackend.profiles.interfaces.rest.resources;

public record CreateProfileResource(String fullname, String username, String email, String password) {
}
