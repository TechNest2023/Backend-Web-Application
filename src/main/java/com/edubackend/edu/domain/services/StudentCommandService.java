package com.edubackend.edu.domain.services;

import com.edubackend.edu.domain.model.commands.CreateStudentCommand;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;

public interface StudentCommandService {
    EduStudentRecordId handle(CreateStudentCommand command);
}
