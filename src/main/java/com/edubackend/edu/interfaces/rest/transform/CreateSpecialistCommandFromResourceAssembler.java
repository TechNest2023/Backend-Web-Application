package com.edubackend.edu.interfaces.rest.transform;
import com.edubackend.edu.domain.model.commands.CreateSpecialistCommand;
import com.edubackend.edu.interfaces.rest.resources.CreateSpecialistResource;

public class CreateSpecialistCommandFromResourceAssembler {
    public static CreateSpecialistCommand toCommandFromResource(CreateSpecialistResource resource){
        return new CreateSpecialistCommand(resource.fullname(), resource.age(), resource.career(),
                resource.specialization(), resource.topics(), resource.language(), resource.nationality(),
                resource.image());
    }
}
