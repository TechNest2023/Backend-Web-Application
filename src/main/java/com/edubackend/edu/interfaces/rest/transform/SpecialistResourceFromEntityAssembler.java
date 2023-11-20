package com.edubackend.edu.interfaces.rest.transform;
import com.edubackend.edu.domain.model.aggregates.Specialist;
import com.edubackend.edu.interfaces.rest.resources.SpecialistResource;

public class SpecialistResourceFromEntityAssembler {
    public static SpecialistResource toResourceFromEntity(Specialist entity){
        return new SpecialistResource(entity.getId(), entity.getFullname(), entity.getAge(),
                entity.getCareer(), entity.getSpecialization(), entity.getTopics(),
                entity.getLanguage(), entity.getNationality(), entity.getImage());
    }
}
