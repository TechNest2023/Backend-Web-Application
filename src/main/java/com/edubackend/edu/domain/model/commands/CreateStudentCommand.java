package com.edubackend.edu.domain.model.commands;
import com.edubackend.edu.domain.model.valueobjects.Birthdate;

import java.util.Date;

public record CreateStudentCommand(String fullname, String username, String email, String password,
                                   String typeOfUser, String universityOrInstitute, String gender,
                                   Birthdate birthdate) {
}
