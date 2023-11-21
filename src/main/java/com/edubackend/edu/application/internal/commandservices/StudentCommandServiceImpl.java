package com.edubackend.edu.application.internal.commandservices;
import com.edubackend.edu.application.internal.outboundservices.acl.ExternalService.ExternalProfileService;
import com.edubackend.edu.domain.model.aggregates.Student;
import com.edubackend.edu.domain.model.commands.CreateStudentCommand;
import com.edubackend.profiles.domain.model.commands.LoginStudentCommand;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.edu.domain.services.StudentCommandService;
import com.edubackend.edu.infraestructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of StudentCommandService
 *
 * <p>
 *     This class is the implementation of the StudentCommandService interface.
 *     It is used by the EduContext to handle commands on the Student aggregate.
 * </p>
 *
 */

@Service
public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentRepository studentRepository;
    private final ExternalProfileService externalProfileService;

    public StudentCommandServiceImpl(StudentRepository studentRepository, ExternalProfileService externalProfileService) {
        this.studentRepository = studentRepository;
        this.externalProfileService = externalProfileService;
    }


    /**
     * Command handler to create student
     *
     * @param command containing student details
     * @return EduStudentRecordId
     */
    @Override
    public EduStudentRecordId handle(CreateStudentCommand command) {
        // Fetch profileId by email
        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());

        // If profileId is empty, create profile
        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(command.fullname(), command.username(), command.email(), command.password());
        } else {
            // If profileId is not empty, check if student exists
            studentRepository.findByProfileId(profileId.get()).ifPresent(student -> {
                throw new IllegalArgumentException("Student already exists");
            });
        }

        // If profileId is still empty, throw exception
        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        // Create student using fetched or created profileId
        var student = new Student(profileId.get(), command.typeOfUser(), command.universityOrInstitute(),
                command.gender(), command.birthdate());
        studentRepository.save(student);
        return student.getEduStudentRecordId();
    }


}
