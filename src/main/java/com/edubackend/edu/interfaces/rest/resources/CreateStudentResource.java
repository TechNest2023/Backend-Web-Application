package com.edubackend.edu.interfaces.rest.resources;

import java.util.Date;

public record CreateStudentResource(String fullName, String userName, String typeOfUser,
                                    String email, String password, String universityOrInstitute,
                                    String gender, String birthdate) {
}
