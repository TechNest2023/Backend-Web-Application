package com.edubackend.edu.application.internal.commandservices;
import com.edubackend.edu.domain.exceptions.SpecialistNotFoundException;
import com.edubackend.edu.domain.model.aggregates.Reserve;
import com.edubackend.edu.domain.model.aggregates.Specialist;
import com.edubackend.edu.domain.model.commands.CancelReserveCommand;
import com.edubackend.edu.domain.model.commands.ConfirmReserveCommand;
import com.edubackend.edu.domain.model.commands.RequestReserveCommand;
import com.edubackend.edu.domain.services.ReserveCommandService;
import com.edubackend.edu.infraestructure.persistence.jpa.repositories.ReserveRepository;
import com.edubackend.edu.infraestructure.persistence.jpa.repositories.SpecialistRepository;
import com.edubackend.edu.infraestructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of ReserveCommandService
 *
 * <p>
 *     This class is the implementation of the ReserveCommandService interface.
 *     It is used by the ReserveContext to handle commands on the Reserve aggregate.
 * </p>
 *
 */

@Service
public class ReserveCommandServiceImpl implements ReserveCommandService {

    private final SpecialistRepository specialistRepository;
    private final StudentRepository studentRepository;
    private final ReserveRepository reserveRepository;


    /**
     * Constructor
     *
     * @param specialistRepository
     * @param studentRepository
     * @param reserveRepository
     */
    public ReserveCommandServiceImpl(SpecialistRepository specialistRepository, StudentRepository studentRepository, ReserveRepository reserveRepository) {
        this.specialistRepository = specialistRepository;
        this.studentRepository = studentRepository;
        this.reserveRepository = reserveRepository;
    }

    @Override
    public Long handle(RequestReserveCommand command) {
        studentRepository.findByEduStudentRecordId(command.studentRecordId()).map(student -> {
            Specialist specialist = specialistRepository.findById(command.specialistId()).orElseThrow(() -> new SpecialistNotFoundException(command.specialistId()));
            Reserve reserve = new Reserve(command.studentRecordId(), specialist);
            reserve = reserveRepository.save(reserve);
            return reserve.getId();
        }).orElseThrow(() -> new RuntimeException("Student not found"));
        return 0L;
    }

    /**
     *  Command handler to confirm reserve
     *
     * @param command containing reserveId
     * @return reserveId
     */
    @Override
    public Long handle(ConfirmReserveCommand command) {
        reserveRepository.findById(command.reserveId()).map(reserve -> {
            reserve.confirm();
            reserveRepository.save(reserve);
            return command.reserveId();
        }).orElseThrow(() -> new RuntimeException("Reserve not found"));
        return null;
    }

    /**
     * Command handler to cancel reserve
     *
     * @param command containing reserveId
     * @return reserveId
     */
    @Override
    public Long handle(CancelReserveCommand command) {
        reserveRepository.findById(command.reserveId()).map(reserve -> {
            reserve.cancel();
            reserveRepository.save(reserve);
            return reserve.getId();
        }).orElseThrow(() -> new RuntimeException("Reserve not found"));
        return null;
    }
}
