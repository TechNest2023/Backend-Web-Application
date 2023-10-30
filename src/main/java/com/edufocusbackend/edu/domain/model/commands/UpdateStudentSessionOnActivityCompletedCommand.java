package com.edufocusbackend.edu.domain.model.commands;
import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;

public record UpdateStudentSessionOnActivityCompletedCommand(StudentRecordId studentRecordId) {
}
