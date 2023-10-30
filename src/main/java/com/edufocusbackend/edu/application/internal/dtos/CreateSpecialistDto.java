package com.edufocusbackend.edu.application.internal.dtos;

import lombok.Data;

@Data
public class CreateSpecialistDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String specialization;
    private String lenguage;
    private String nationality;
}
