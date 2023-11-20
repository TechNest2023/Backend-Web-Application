package com.edubackend.edu.interfaces.rest.transform;
import com.edubackend.edu.domain.model.commands.CreateStudentCommand;
import com.edubackend.edu.domain.model.valueobjects.Birthdate;
import com.edubackend.edu.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {

    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource){
        return new CreateStudentCommand(
                resource.fullName(),
                resource.userName(),
                resource.email(),
                resource.password(),
                resource.typeOfUser(),
                resource.universityOrInstitute(),
                resource.gender(),
                new Birthdate(resource.birthdate())
        );
    }
}
