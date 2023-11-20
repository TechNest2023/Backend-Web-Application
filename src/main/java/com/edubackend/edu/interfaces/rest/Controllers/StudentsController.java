package com.edubackend.edu.interfaces.rest.Controllers;
import com.edubackend.edu.domain.model.queries.GetStudentByEduStudentRecordIdQuery;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.edu.domain.services.StudentCommandService;
import com.edubackend.edu.domain.services.StudentQueryService;
import com.edubackend.edu.interfaces.rest.resources.CreateStudentResource;
import com.edubackend.edu.interfaces.rest.resources.StudentResource;
import com.edubackend.edu.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import com.edubackend.edu.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * StudentsController
 *
 * <p>Controller that handles the endpoints for students.
 * It uses the {@link StudentCommandService} and {@link StudentQueryService} to handle the commands and queries
 * for students.
 * <ul>
 *     <li>POST /api/v1/students</li>
 *     <li>GET /api/v1/students/{studentRecordId}</li>
 * </ul>
 * </p>
 */


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Students", description = "Student Management Endpoints")
public class StudentsController {

    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;


    public StudentsController(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    /**
     * POST /api/v1/students
     *
     * <p>Endpoint that creates a student</p>
     *
     * @param resource the resource with the information to create the student
     * @return the created student
     * @see CreateStudentResource
     * @see StudentResource
     */
    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var studentId = studentCommandService.handle(createStudentCommand);
        if (studentId.studentRecordId().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getStudentByEduStudentRecordIdQuery = new GetStudentByEduStudentRecordIdQuery(studentId);
        var student = studentQueryService.handle(getStudentByEduStudentRecordIdQuery);
        if (student.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }


    /**
     * GET /api/v1/students/{studentRecordId}
     *
     * <p>Endpoint that gets a student by its acme student record id</p>
     *
     * @param studentRecordId the edu student record id
     * @return the student resource
     * @see StudentResource
     */
    @GetMapping("/{studentRecordId}")
    public ResponseEntity<StudentResource> getStudentByEduStudentRecordId(@PathVariable String studentRecordId) {
        var eduStudentRecordId = new EduStudentRecordId(studentRecordId);
        var getStudentByEduStudentRecordIdQuery = new GetStudentByEduStudentRecordIdQuery(eduStudentRecordId);
        var student = studentQueryService.handle(getStudentByEduStudentRecordIdQuery);
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return ResponseEntity.ok(studentResource);
    }
}
