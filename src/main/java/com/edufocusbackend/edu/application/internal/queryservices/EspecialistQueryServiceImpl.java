package com.edufocusbackend.edu.application.internal.queryservices;

import com.edufocusbackend.edu.domain.model.aggregates.Specialist;
import com.edufocusbackend.edu.domain.model.queries.GetAllEspecialistsQuery;
import com.edufocusbackend.edu.domain.model.queries.GetEspecialistByIdQuery;
import com.edufocusbackend.edu.domain.services.EspecialistQueryService;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.SpecialistRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialistQueryServiceImpl implements EspecialistQueryService {
    private SpecialistRepository specialistRepository;
    public EspecialistQueryServiceImpl(SpecialistRepository specialistRepository){
            this.specialistRepository = specialistRepository;
    }
    @Override
    public List<Specialist> handle(GetAllEspecialistsQuery query){
        return  specialistRepository.findAll();
    }
    @Override
    public Specialist handle(GetEspecialistByIdQuery query){
        return specialistRepository.findById(query.specialistId()).get();
    }
}
