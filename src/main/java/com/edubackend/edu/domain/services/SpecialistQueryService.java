package com.edubackend.edu.domain.services;
import com.edubackend.edu.domain.model.aggregates.Specialist;
import com.edubackend.edu.domain.model.queries.GetAllSpecialistQuery;
import com.edubackend.edu.domain.model.queries.GetSpecialistByIdQuery;
import java.util.List;
import java.util.Optional;

public interface SpecialistQueryService {
    Optional<Specialist> handle(GetSpecialistByIdQuery query);
    List<Specialist> handle(GetAllSpecialistQuery query);
}
