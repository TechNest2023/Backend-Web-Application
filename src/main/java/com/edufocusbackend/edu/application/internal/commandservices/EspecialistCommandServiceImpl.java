package com.edufocusbackend.edu.application.internal.commandservices;

import com.edufocusbackend.edu.domain.model.aggregates.Specialist;
import com.edufocusbackend.edu.domain.model.commands.CreateSpecialistCommand;
import com.edufocusbackend.edu.domain.services.EspecialistCommandService;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.SpecialistRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class EspecialistCommandServiceImpl implements EspecialistCommandService {
    private SpecialistRepository specialistRepository;
    public EspecialistCommandServiceImpl(SpecialistRepository specialistRepository){
        this.specialistRepository = specialistRepository;
    }
    @Override
    public long handle(CreateSpecialistCommand command){
        Specialist specialist = new Specialist();
        specialist.setFirstName(command.firstName());
        specialist.setLastname(command.lastName());
        specialist.setAge(command.age());
        specialist.setLanguage(command.lenguage());
        specialist.setNationality(command.nationality());

        return specialistRepository.save(specialist).getId();
    }

}
