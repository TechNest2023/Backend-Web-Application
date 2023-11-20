package com.edubackend.edu.interfaces.rest.Controllers;
import com.edubackend.edu.domain.model.commands.CancelReserveCommand;
import com.edubackend.edu.domain.model.commands.ConfirmReserveCommand;
import com.edubackend.edu.domain.model.queries.GetAllReserveQuery;
import com.edubackend.edu.domain.model.queries.GetReserveByEduStudentRecordIdAndSpecialistIdQuery;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.edu.domain.services.ReserveCommandService;
import com.edubackend.edu.domain.services.ReserveQueryService;
import com.edubackend.edu.interfaces.rest.resources.RequestReserveResource;
import com.edubackend.edu.interfaces.rest.resources.ReserveResource;
import com.edubackend.edu.interfaces.rest.transform.RequestReserveCommandFromResourceAssembler;
import com.edubackend.edu.interfaces.rest.transform.ReserveResourceFromEntityAssembler;
import com.edubackend.shared.interfaces.rest.resources.MessageResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Inbound service for the Reserve aggregate.
 * <p>
 * This controller is responsible for handling requests related to the Reserve aggregate.
 * It uses the {@link ReserveCommandService} and {@link ReserveQueryService} to handle the commands and queries
 * for reservations.
 * <ul>
 *     <li>POST /api/v1/reservations</li>
 *     <li>POST /api/v1/reservations/{reserveId}/confirmations</li>
 *     <li>POST /api/v1/reservations/{reserveId}/cancellations</li>
 * </ul>
 * <p>
 */

@RestController
@RequestMapping(value = "/api/v1/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reservations", description = "Reserve Management Endpoints")
public class ReservationsController {

    private final ReserveCommandService reserveCommandService;
    private final ReserveQueryService reserveQueryService;


    public ReservationsController(ReserveCommandService reserveCommandService, ReserveQueryService reserveQueryService) {
        this.reserveCommandService = reserveCommandService;
        this.reserveQueryService = reserveQueryService;
    }


    /**
     * Handles a request to reserve a student in a specialist.
     *
     * @param resource The reserve resource.
     * @return The reserve resource
     * @see RequestReserveResource
     * @see ReserveResource
     */
    @PostMapping
    public ResponseEntity<ReserveResource> requestEnrollment(@RequestBody RequestReserveResource resource) {
        var command = RequestReserveCommandFromResourceAssembler.toCommandFromResource(resource);
        var reserveId = reserveCommandService.handle(command);
        System.out.println("Reserve ID: " + reserveId);
        var getReserveByEduStudentRecordIdAndSpecialistIdQuery =
                new GetReserveByEduStudentRecordIdAndSpecialistIdQuery(new EduStudentRecordId(resource.studentRecordId()), resource.specialistId());
        var reserve = reserveQueryService.handle(getReserveByEduStudentRecordIdAndSpecialistIdQuery);
        if (reserve.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var reserveResource = ReserveResourceFromEntityAssembler.toResourceFromEntity(reserve.get());
        return new ResponseEntity<>(reserveResource, HttpStatus.CREATED);
    }


    /**
     * Handles a request to confirm a reserve.
     * @param reserveId The reserve ID.
     * @return MessageResource with The reserve ID.
     * @see MessageResource
     */
    @PostMapping("/{reserveId}/confirmations")
    public ResponseEntity<MessageResource> confirmReserve(@PathVariable Long reserveId) {
        var confirmReserveCommand = new ConfirmReserveCommand(reserveId);
        reserveCommandService.handle(confirmReserveCommand);
        return ResponseEntity.ok(new MessageResource("Confirmed Reserve ID: " + reserveId));
    }


    /**
     * Handles a request to cancel an reserve.
     * @param reserveId The reserve ID.
     * @return MessageResource with the reserve ID.
     * @see MessageResource
     */
    @PostMapping("/{reserveId}/cancellations")
    public ResponseEntity<MessageResource> cancelReserve(@PathVariable Long reserveId) {
        var cancelReserveCommand = new CancelReserveCommand(reserveId);
        reserveCommandService.handle(cancelReserveCommand);
        return ResponseEntity.ok(new MessageResource("Cancelled Reserve ID: "+ reserveId));
    }


    /**
     * Gets all the reservations.
     * @return The list of all the reserve resources available.
     * @see ReserveResource
     */
    @GetMapping
    public ResponseEntity<List<ReserveResource>> getAllReservations() {
        var getAllReservationsQuery = new GetAllReserveQuery();
        var reservations = reserveQueryService.handle(getAllReservationsQuery);
        var reserveResources = reservations.stream().map(ReserveResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reserveResources);
    }

}
