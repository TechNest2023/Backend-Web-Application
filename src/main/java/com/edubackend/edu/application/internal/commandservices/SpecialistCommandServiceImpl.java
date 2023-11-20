package com.edubackend.edu.application.internal.commandservices;
import com.edubackend.edu.domain.model.aggregates.Specialist;
import com.edubackend.edu.domain.model.commands.CreateSpecialistCommand;
import com.edubackend.edu.domain.services.SpecialistCommandService;
import com.edubackend.edu.infraestructure.persistence.jpa.repositories.SpecialistRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecialistCommandServiceImpl implements SpecialistCommandService {

    private final SpecialistRepository specialistRepository;

    public SpecialistCommandServiceImpl(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }

    @Override
    public Long handle(CreateSpecialistCommand command) {
        if (specialistRepository.existsByFullname(command.fullName())) {
            throw new IllegalArgumentException("Course with same fullname already exists");
        }

        var specialist = new Specialist(command.fullName(), command.age(), command.career(),
                command.specialization(), command.topic(), command.language(), command.nationality(),
                command.image());
        specialistRepository.save(specialist);
        return specialist.getId();
    }
}
