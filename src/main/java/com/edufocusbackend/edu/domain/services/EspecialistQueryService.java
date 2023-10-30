package com.edufocusbackend.edu.domain.services;

import com.edufocusbackend.edu.domain.model.aggregates.Specialist;
import com.edufocusbackend.edu.domain.model.queries.GetAllEspecialistsQuery;
import com.edufocusbackend.edu.domain.model.queries.GetEspecialistByIdQuery;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.SpecialistRepository;

import java.util.List;

public interface EspecialistQueryService {
    public List<Specialist> handle(GetAllEspecialistsQuery query);
    public Specialist handle(GetEspecialistByIdQuery query);
}
