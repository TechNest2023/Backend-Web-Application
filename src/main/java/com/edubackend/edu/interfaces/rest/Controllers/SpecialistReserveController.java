package com.edubackend.edu.interfaces.rest.Controllers;
import com.edubackend.edu.domain.model.queries.GetSpecialistReserveQuery;
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
 * SpecialistReserveController
 *
 * <p>Controller that handles the endpoints for specialist reserve.
 * It uses the {@link ReserveQueryService} to handle the queries
 * for reserves.
 * <ul>
 *     <li>GET /api/v1/specialist/{specialistId}/reserve</li>
 * </ul>
 * </p>
 */

@RestController
@RequestMapping(value = "/api/v1/specialists/{specialistId}/reservations", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Specialists")
public class SpecialistReserveController {
    private final ReserveQueryService reserveQueryService;


    public SpecialistReserveController(ReserveQueryService reserveQueryService) {
        this.reserveQueryService = reserveQueryService;
    }


    /**
     * GET /api/v1/specialist/{specialistId}/reservations
     *
     * <p>Endpoint that returns the reservations for a specialist</p>
     *
     * @param specialistId the specialist Id
     * @return the reserve resources for the specialist with given ID
     * @see ReserveResource
     */
    @GetMapping
    public ResponseEntity<List<ReserveResource>> getReservationsForSpecialistWithId(@PathVariable Long specialistId) {
        var getSpecialistReserveQuery = new GetSpecialistReserveQuery(specialistId);
        var reservations = reserveQueryService.handle(getSpecialistReserveQuery);
        var reserveResources = reservations.stream().map(ReserveResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reserveResources);
    }
}
