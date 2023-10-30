package com.edufocusbackend.edu.application.internal.mappers;

import com.edufocusbackend.edu.application.internal.dtos.CreateSpecialistDto;
import com.edufocusbackend.edu.domain.model.aggregates.Specialist;

public class CreateSpecialistToSpecialist {
    public static Specialist Map(CreateSpecialistDto dto){
        Specialist specialist = new Specialist();
        specialist.setFirstName(dto.getFirstName());
        specialist.setLastname(dto.getLastName());
        specialist.setAge(dto.getAge());
        specialist.setLanguage(dto.getLenguage());
        specialist.setSpecialization(dto.getSpecialization());
        specialist.setNationality(dto.getNationality());
        return specialist;
    }
}
