package com.edufocusbackend.edu.interfaces.rest.controllers;

import com.edufocusbackend.edu.application.internal.commandservices.EspecialistCommandServiceImpl;
import com.edufocusbackend.edu.application.internal.dtos.CreateSpecialistDto;
import com.edufocusbackend.edu.application.internal.mappers.CreateSpecialistToSpecialist;
import com.edufocusbackend.edu.application.internal.queryservices.EspecialistQueryServiceImpl;
import com.edufocusbackend.edu.domain.model.aggregates.Specialist;
import com.edufocusbackend.edu.domain.model.queries.GetAllEspecialistsQuery;
import com.edufocusbackend.edu.domain.services.EspecialistCommandService;
import com.edufocusbackend.edu.domain.services.EspecialistQueryService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("Especialist")
public class EspecialistController {
    private EspecialistQueryServiceImpl specialistQueryService;
    private EspecialistCommandServiceImpl specialistCommandService;

    public EspecialistController(EspecialistQueryServiceImpl specialistQueryService,
                                 EspecialistCommandServiceImpl specialistCommandService){
        this.specialistQueryService = specialistQueryService;
        this.specialistCommandService = specialistCommandService;
    }
    @GetMapping
    public ResponseEntity<List<Specialist>> getAllSpecialists(){
        GetAllEspecialistsQuery query = new GetAllEspecialistsQuery();
        List<Specialist> specialists = specialistQueryService.handle(query);
        return ResponseEntity.status(HttpStatus.OK).body(specialists);
    }
    @PostMapping
    public  ResponseEntity<Long> createSpecialist(@RequestBody CreateSpecialistDto specialist){
        Specialist specialistToAdd = CreateSpecialistToSpecialist.Map(specialist);
        CreateSpecialistToSpecialist command = new CreateSpecialistToSpecialist();
        specialistToAdd = specialistCommandService.handle(command);
    }
}
