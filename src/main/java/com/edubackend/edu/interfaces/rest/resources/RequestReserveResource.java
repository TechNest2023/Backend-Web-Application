package com.edubackend.edu.interfaces.rest.resources;
import jakarta.validation.constraints.NotNull;

public record RequestReserveResource(
        @NotNull
        String studentRecordId,
        @NotNull
        Long specialistId
) {
}
