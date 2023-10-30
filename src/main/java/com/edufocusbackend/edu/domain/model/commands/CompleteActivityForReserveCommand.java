package com.edufocusbackend.edu.domain.model.commands;

public record CompleteActivityForReserveCommand (Long reserveId, Long activityId) {
}
