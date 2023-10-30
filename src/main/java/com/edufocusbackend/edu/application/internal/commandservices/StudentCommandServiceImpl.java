package com.edufocusbackend.edu.application.internal.commandservices;
import com.edufocusbackend.edu.domain.model.aggregates.Student;
import com.edufocusbackend.edu.domain.model.commands.CreateStudentCommand;
import com.edufocusbackend.edu.domain.model.commands.UpdateStudentSessionOnActivityCompletedCommand;
import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;
import com.edufocusbackend.edu.domain.services.StudentCommandService;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.StudentRepository;

public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentRecordId handle(CreateStudentCommand command){

        //TODO pendiente de implementar
        Student studentToadd = new Student();
        studentToadd = studentRepository.save(studentToadd);
        return new StudentRecordId();
    }

    @Override
    public StudentRecordId handle(UpdateStudentSessionOnActivityCompletedCommand command){
        studentRepository.findByStudentRecordId(command.studentRecordId()).map(student -> {
            student.updateActivityCompleted();
            studentRepository.save(student);
            return student.getStudentRecordId();
        }).orElseThrow(()-> new IllegalArgumentException("Student with given Id not found"));
        return null;
    }
}
