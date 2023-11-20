package com.edubackend.edu.application.internal.queryservices;
import com.edubackend.edu.domain.model.aggregates.Specialist;
import com.edubackend.edu.domain.model.queries.GetAllSpecialistQuery;
import com.edubackend.edu.domain.model.queries.GetSpecialistByIdQuery;
import com.edubackend.edu.domain.services.SpecialistQueryService;
import com.edubackend.edu.infraestructure.persistence.jpa.repositories.SpecialistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialistQueryServiceImpl implements SpecialistQueryService {

    private final SpecialistRepository specialistRepository;

    public SpecialistQueryServiceImpl(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }

    @Override
    public Optional<Specialist> handle(GetSpecialistByIdQuery query) {
        return specialistRepository.findById(query.specialistId());
    }

    @Override
    public List<Specialist> handle(GetAllSpecialistQuery query) {
        return specialistRepository.findAll();
    }
}
