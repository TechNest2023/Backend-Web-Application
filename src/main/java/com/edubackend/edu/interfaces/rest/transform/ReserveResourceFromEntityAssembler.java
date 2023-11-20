package com.edubackend.edu.interfaces.rest.transform;
import com.edubackend.edu.domain.model.aggregates.Reserve;
import com.edubackend.edu.interfaces.rest.resources.ReserveResource;

/**
 * ReserveResourceFromEntityAssembler.
 * <p>
 * This class is used to transform an Reserve entity into an ReserveResource.
 * </p>
 */
public class ReserveResourceFromEntityAssembler {
    /**
     * Transform a Reserve entity into an ReserveResource.
     * @param reserve Reserve entity to be transformed.
     * @return ReserveResource the resulting resource.
     */
    public static ReserveResource toResourceFromEntity(Reserve reserve){
        return new ReserveResource(reserve.getId(), reserve.getEduStudentRecordId().studentRecordId(),
                reserve.getSpecialist().getId(), reserve.getStatus());
    }
}
