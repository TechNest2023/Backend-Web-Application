package com.edubackend.edu.interfaces.rest.Controllers;


import com.edubackend.edu.domain.model.queries.GetStudentReserveQuery;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.edu.domain.services.ReserveQueryService;
import com.edubackend.edu.interfaces.rest.resources.ReserveResource;
import com.edubackend.edu.interfaces.rest.transform.ReserveResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * StudentReservationsController
 *
 * <p>Controller that handles the endpoints for students.
 * It uses the {@link ReserveQueryService} to handle the queries
 * for reservations.
 * <ul>
 *     <li>GET /api/v1/students/{studentRecordId}/reservations</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/students/{studentRecordId}/reservations", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Students")
public class StudentReservationsController {
    private final ReserveQueryService reserveQueryService;

    public StudentReservationsController(ReserveQueryService reserveQueryService) {
        this.reserveQueryService = reserveQueryService;
    }

    @GetMapping
    public ResponseEntity<List<ReserveResource>> getReservationsForStudentWithStudentRecordId(@PathVariable String studentRecordId) {
        var eduStudentRecordId = new EduStudentRecordId(studentRecordId);
        var getStudentReservationsQuery = new GetStudentReserveQuery(eduStudentRecordId);
        var reservations = reserveQueryService.handle(getStudentReservationsQuery);
        var reserveResources = reservations.stream().map(ReserveResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reserveResources);
    }
}
