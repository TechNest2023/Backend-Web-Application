package com.edufocusbackend.edu.domain.services;
import com.edufocusbackend.edu.domain.model.commands.CreateStudentCommand;
import com.edufocusbackend.edu.domain.model.commands.UpdateStudentSessionOnActivityCompletedCommand;
import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;

public interface StudentCommandService {
    StudentRecordId handle(CreateStudentCommand command);
    StudentRecordId handle(UpdateStudentSessionOnActivityCompletedCommand command);
}
