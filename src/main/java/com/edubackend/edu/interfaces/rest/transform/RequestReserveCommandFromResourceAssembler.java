package com.edubackend.edu.interfaces.rest.transform;

import com.edubackend.edu.domain.model.commands.RequestReserveCommand;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.edu.interfaces.rest.resources.RequestReserveResource;

public class RequestReserveCommandFromResourceAssembler {
    public static RequestReserveCommand toCommandFromResource(RequestReserveResource resource){
        return new RequestReserveCommand(new EduStudentRecordId(resource.studentRecordId()), resource.specialistId());
    }
}
