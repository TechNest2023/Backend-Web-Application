package com.edubackend.edu.domain.model.commands;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;

public record RequestReserveCommand(EduStudentRecordId studentRecordId, Long specialistId) {
}
