package com.edubackend.edu.interfaces.rest.Controllers;

import com.edubackend.edu.domain.model.queries.GetAllSpecialistQuery;
import com.edubackend.edu.domain.model.queries.GetSpecialistByIdQuery;
import com.edubackend.edu.domain.services.SpecialistCommandService;
import com.edubackend.edu.domain.services.SpecialistQueryService;
import com.edubackend.edu.interfaces.rest.resources.CreateSpecialistResource;
import com.edubackend.edu.interfaces.rest.resources.SpecialistResource;
import com.edubackend.edu.interfaces.rest.transform.CreateSpecialistCommandFromResourceAssembler;
import com.edubackend.edu.interfaces.rest.transform.SpecialistResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Specialists Controller
 * <p>
 * This class is the entry point for all the REST API calls related to specialists.
 * It is responsible for handling the requests and delegating the processing to the appropriate services.
 * It also transforms the data from the request to the appropriate commands and vice versa.
 * <ul>
 *     <li>POST /api/v1/specialists</li>
 *     <li>GET /api/v1/specialists/{specialistId}</li>
 *     <li>GET /api/v1/specialists</li>
 * </ul>
 * </p>
 */

@RestController
@RequestMapping(value = "/api/v1/specialists", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Specialists", description = "Specialist Management Endpoints")
public class SpecialistsController {
    private final SpecialistCommandService specialistCommandService;
    private final SpecialistQueryService specialistQueryService;

    public SpecialistsController(SpecialistCommandService specialistCommandService, SpecialistQueryService specialistQueryService) {
        this.specialistCommandService = specialistCommandService;
        this.specialistQueryService = specialistQueryService;
    }


    /**
     * Creates a new specialist
     *
     * @param createSpecialistResource the resource containing the data for the specialist to be created
     * @return the created specialist resource
     * @see CreateSpecialistResource
     * @see SpecialistResource
     */
    @PostMapping
    public ResponseEntity<SpecialistResource> createSpecialist(@RequestBody CreateSpecialistResource createSpecialistResource) {
        var createSpecialistCommand = CreateSpecialistCommandFromResourceAssembler.toCommandFromResource(createSpecialistResource);
        var specialistId = specialistCommandService.handle(createSpecialistCommand);
        if (specialistId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getSpecialistByIdQuery = new GetSpecialistByIdQuery(specialistId);
        var specialist = specialistQueryService.handle(getSpecialistByIdQuery);
        if (specialist.isEmpty()) return ResponseEntity.badRequest().build();
        var specialistResource = SpecialistResourceFromEntityAssembler.toResourceFromEntity(specialist.get());
        return new ResponseEntity<>(specialistResource, HttpStatus.CREATED);
    }

    /**
     * Gets a specialist by its id.
     *
     * @param specialistId the id of the specialist to be retrieved
     * @return the specialist resource with the given id
     * @see SpecialistResource
     */
    @GetMapping("/{specialistId}")
    public ResponseEntity<SpecialistResource> getSpecialistById(@PathVariable Long specialistId) {
        var getSpecialistByIdQuery = new GetSpecialistByIdQuery(specialistId);
        var specialist = specialistQueryService.handle(getSpecialistByIdQuery);
        if (specialist.isEmpty()) return ResponseEntity.badRequest().build();
        var specialistResource = SpecialistResourceFromEntityAssembler.toResourceFromEntity(specialist.get());
        return ResponseEntity.ok(specialistResource);
    }

    /**
     * Gets all the specialists.
     * @return the list of all the specialist resources
     * @see SpecialistResource
     */
    @GetMapping
    public ResponseEntity<List<SpecialistResource>> getAllSpecialists() {
        var getAllSpecialistQuery = new GetAllSpecialistQuery();
        var specialists = specialistQueryService.handle(getAllSpecialistQuery);
        var specialistResources = specialists.stream().map(SpecialistResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(specialistResources);
    }
}
