package com.edubackend.edu.domain.services;
import com.edubackend.edu.domain.model.commands.CancelReserveCommand;
import com.edubackend.edu.domain.model.commands.ConfirmReserveCommand;
import com.edubackend.edu.domain.model.commands.RequestReserveCommand;

public interface ReserveCommandService {
    Long handle(RequestReserveCommand command);

    Long handle(ConfirmReserveCommand command);
    Long handle(CancelReserveCommand command);
}
