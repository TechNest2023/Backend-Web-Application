package com.edufocusbackend.edu.interfaces.rest.controllers;
import com.edufocusbackend.edu.application.internal.queryservices.StudentQueryServiceImpl;
import com.edufocusbackend.edu.domain.model.aggregates.Student;
import com.edufocusbackend.edu.domain.model.queries.GetStudentByProfileIdQuery;
import com.edufocusbackend.edu.domain.model.valueobjects.ProfileId;
import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("Student")
public class StudentController {
    private final StudentQueryServiceImpl studentQueryService;
    public StudentController(StudentQueryServiceImpl studentQueryService){
        this.studentQueryService = studentQueryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getById(@PathVariable long id){
        GetStudentByProfileIdQuery query = new GetStudentByProfileIdQuery(new ProfileId(id));
        Optional<Student> student = studentQueryService.handle(query);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    @PostMapping()
    public ResponseEntity<Optional<StudentRecordId>> createStudent(@RequestBody Student student){
        return ResponseEntity.ok().build();
    }
}
