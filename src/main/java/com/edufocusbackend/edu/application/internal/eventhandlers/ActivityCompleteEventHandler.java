package com.edufocusbackend.edu.application.internal.eventhandlers;
import com.edufocusbackend.edu.domain.model.events.ActivityCompletedEvent;
import com.edufocusbackend.edu.domain.model.queries.GetReserveByIdQuery;
import com.edufocusbackend.edu.domain.services.ReserveCommandService;
import com.edufocusbackend.edu.domain.services.ReserveQueryService;
import com.edufocusbackend.edu.domain.services.StudentCommandService;
import com.edufocusbackend.edu.domain.services.StudentQueryService;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.StudentRepository;
import org.springframework.context.event.EventListener;

public class ActivityCompleteEventHandler {

    private  final StudentQueryService studentCommandService;
    private  final ReserveCommandService reserveCommandService;

    public ActivityCompleteEventHandler(StudentQueryService studentCommandService, ReserveCommandService reserveCommandService){
        this.studentCommandService = studentCommandService;
        this.reserveCommandService = reserveCommandService;
    }

    @EventListener(ActivityCompletedEvent.class)
    public void on(ActivityCompletedEvent event){

        //GetReserveByIdQuery getReserveByIdQuery = new GetReserveByIdQuery(event.ge)
    }
}
