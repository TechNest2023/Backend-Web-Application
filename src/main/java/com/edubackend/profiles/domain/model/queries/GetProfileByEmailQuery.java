package com.edubackend.profiles.domain.model.queries;
import com.edubackend.profiles.domain.model.valueobjects.Email;

public record GetProfileByEmailQuery(Email emailAddress) {
}
