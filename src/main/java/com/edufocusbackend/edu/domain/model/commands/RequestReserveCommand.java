package com.edufocusbackend.edu.domain.model.commands;

import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;

public record RequestReserveCommand(StudentRecordId studentRecordId, Long activityId) {
}
