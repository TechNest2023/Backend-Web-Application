package com.edufocusbackend.edu.application.internal.commandservices;
import com.edufocusbackend.edu.domain.exceptions.ActivityNotFoundException;
import com.edufocusbackend.edu.domain.exceptions.SpecialistNotFoundException;
import com.edufocusbackend.edu.domain.model.aggregates.Reserve;
import com.edufocusbackend.edu.domain.model.aggregates.Specialist;
import com.edufocusbackend.edu.domain.model.commands.*;
import com.edufocusbackend.edu.domain.services.ReserveCommandService;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.ReserveRepository;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.SpecialistRepository;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.StudentRepository;

public class ReserveCommandServiceImpl implements ReserveCommandService {
    private final SpecialistRepository specialistRepository;
    private final StudentRepository studentRepository;
    private final ReserveRepository reserveRepository;

    public ReserveCommandServiceImpl (SpecialistRepository specialistRepository, StudentRepository studentRepository, ReserveRepository reserveRepository){
        this.reserveRepository = reserveRepository;
        this.studentRepository = studentRepository;
        this.specialistRepository = specialistRepository;
    }


    @Override
    public Long handle(RequestReserveCommand command) {
        studentRepository.findByStudentRecordId(command.studentRecordId()).map(student ->
        {
            Specialist specialist =  specialistRepository.findById(command.activityId()).orElseThrow(() ->
                    new SpecialistNotFoundException(command.activityId()));
            Reserve reserve = new Reserve(command.studentRecordId(), specialist);
            reserveRepository.save(reserve);
            return reserve.getId();
        }).orElseThrow(()-> new RuntimeException("Student not found"));
        return 0L;
    }

    @Override
    public Long handle(ConfirmReserveCommand command) {
        reserveRepository.findById(command.reserveId()).map(
                reserve ->
                {
                    reserve.confirm();
                    reserveRepository.save(reserve);
                    return reserve.getId();
                }
        ).orElseThrow(() -> new RuntimeException("Reserve not found"));
        return null;
    }

    @Override
    public Long handle(RejectReserveCommand command) {
        reserveRepository.findById(command.reserveId()).map(reserve -> {
            reserve.reject();
            reserveRepository.save(reserve);
            return  reserve.getId();
        }).orElseThrow(()-> new RuntimeException("Reserve not found"));
        return null;
    }

    @Override
    public Long handle(CancelReserveCommand command) {
        reserveRepository.findById(command.reserveId()).map(reserve -> {
            reserve.cancel();
            reserveRepository.save(reserve);
            return reserve.getId();
        }).orElseThrow(()-> new RuntimeException("Reserve not found"));
        return null;
    }

    @Override
    public Long handle(CompleteActivityForReserveCommand command){
        reserveRepository.findById(command.reserveId()).map(reserve -> {
            reserve.completeActivity(command.reserveId());
            reserveRepository.save(reserve);
            return reserve.getId();
        }).orElseThrow(()-> new RuntimeException("Reserve not found"));
        return null;
    }

}
