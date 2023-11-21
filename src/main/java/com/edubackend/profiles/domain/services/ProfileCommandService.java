package com.edubackend.profiles.domain.services;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.profiles.domain.model.commands.CreateProfileCommand;
import com.edubackend.profiles.domain.model.commands.LoginStudentCommand;

public interface ProfileCommandService {
    Long handle(CreateProfileCommand command);
    EduStudentRecordId handle(LoginStudentCommand command);

}
