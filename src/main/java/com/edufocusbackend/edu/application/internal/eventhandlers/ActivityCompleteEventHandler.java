package com.edufocusbackend.edu.application.internal.eventhandlers;
import com.edufocusbackend.edu.domain.model.commands.UpdateStudentSessionOnActivityCompletedCommand;
import com.edufocusbackend.edu.domain.model.events.ActivityCompletedEvent;
import com.edufocusbackend.edu.domain.model.queries.GetReserveByIdQuery;
import com.edufocusbackend.edu.domain.services.ReserveCommandService;
import com.edufocusbackend.edu.domain.services.ReserveQueryService;
import com.edufocusbackend.edu.domain.services.StudentCommandService;
import com.edufocusbackend.edu.domain.services.StudentQueryService;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.StudentRepository;
import org.springframework.context.event.EventListener;

public class ActivityCompleteEventHandler {

    private  final StudentCommandService studentCommandService;
    private  final ReserveQueryService reserveQueryService;

    public ActivityCompleteEventHandler(StudentCommandService studentCommandService, ReserveQueryService reserveQueryService){
        this.studentCommandService = studentCommandService;
        this.reserveQueryService = reserveQueryService;
    }

    @EventListener(ActivityCompletedEvent.class)
    public void on(ActivityCompletedEvent event){

        var getReserveByIdQuery = new GetReserveByIdQuery(event.getReserveId());
        var reserve = reserveQueryService.handle(getReserveByIdQuery);

        if (reserve.isPresent()){
            var updateStudentSessionOnActivityCompletedCommand = new UpdateStudentSessionOnActivityCompletedCommand(
                    reserve.get().getStudentRecordId());
            studentCommandService.handle(updateStudentSessionOnActivityCompletedCommand);

            System.out.println("ActivityCompletedEventHandler executed");
        }

    }
}
