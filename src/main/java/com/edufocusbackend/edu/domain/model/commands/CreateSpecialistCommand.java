package com.edufocusbackend.edu.domain.model.commands;

public record CreateSpecialistCommand(
        String firstName,
        String lastName,
        Integer age,
        String specialization,
        String lenguage,
        String nationality) {
}
