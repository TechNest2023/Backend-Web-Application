package com.edubackend.edu.application.internal.queryservices;
import com.edubackend.edu.domain.model.aggregates.Reserve;
import com.edubackend.edu.domain.model.queries.*;
import com.edubackend.edu.domain.services.ReserveQueryService;
import com.edubackend.edu.infraestructure.persistence.jpa.repositories.ReserveRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReserveQueryServiceImpl implements ReserveQueryService {

    private final ReserveRepository reserveRepository;

    public ReserveQueryServiceImpl(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }


    /**
     * Query handler to get student reserve
     *
     * @param query containing studentRecordId
     * @return List of reserve
     * @see Reserve
     * @see GetStudentReserveQuery
     */
    @Override
    public List<Reserve> handle(GetStudentReserveQuery query) {
        return reserveRepository.findAllByEduStudentRecordId(query.eduStudentRecordId());
    }

    /**
     * Query handler to get reserve by id
     *
     * @param query containing reserveId
     * @return Reserve
     * @see Reserve
     * @see GetReserveByIdQuery
     */
    @Override
    public Optional<Reserve> handle(GetReserveByIdQuery query) {
        return reserveRepository.findById(query.reserveId());
    }

    /**
     *  Query handler to get all reserve
     * @param query containing no parameters
     * @return List of reserve
     * @see Reserve
     * @see GetReserveByIdQuery
     */
    @Override
    public List<Reserve> handle(GetAllReserveQuery query) {
        return reserveRepository.findAll();
    }


    /**
     * Query handler to get specialist reserve
     *
     * @param query containing specialistId
     * @return List of reserve
     * @see Reserve
     * @see GetSpecialistReserveQuery
     */
    @Override
    public List<Reserve> handle(GetSpecialistReserveQuery query) {
        return reserveRepository.findAllBySpecialistId(query.specialistId());
    }

    @Override
    public Optional<Reserve> handle(GetReserveByEduStudentRecordIdAndSpecialistIdQuery query) {
        return reserveRepository.findByEduStudentRecordIdAndSpecialistId(query.eduStudentRecordId(), query.specialistId());
    }
}
