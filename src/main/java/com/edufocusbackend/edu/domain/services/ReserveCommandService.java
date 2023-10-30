package com.edufocusbackend.edu.domain.services;
import com.edufocusbackend.edu.domain.model.commands.*;

public interface ReserveCommandService {
    Long handle(RequestReserveCommand command);

    Long handle(ConfirmReserveCommand command);

    Long handle(RejectReserveCommand command);

    Long handle(CancelReserveCommand command);

    Long handle(CompleteActivityForReserveCommand command);
}
