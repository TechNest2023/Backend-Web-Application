package com.edufocusbackend.edu.application.internal.queryservices;
import com.edufocusbackend.edu.domain.model.aggregates.Reserve;
import com.edufocusbackend.edu.domain.model.aggregates.Specialist;
import com.edufocusbackend.edu.domain.model.queries.GetAllEspecialistsQuery;
import com.edufocusbackend.edu.domain.model.queries.GetReserveByIdQuery;
import com.edufocusbackend.edu.domain.model.queries.GetStudentReserveQuery;
import com.edufocusbackend.edu.domain.services.ReserveQueryService;
import com.edufocusbackend.edu.infraestructure.persistance.jpa.repositories.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReserveQueryServiceImpl implements ReserveQueryService {
    private final ReserveRepository reserveRepository;
    public ReserveQueryServiceImpl(ReserveRepository reserveRepository){
        this.reserveRepository = reserveRepository;
    }

    public List<Reserve> handle(GetStudentReserveQuery query){
        return reserveRepository.findAllByStudentRecordId(query.studentRecordId());
    }
    public Optional<Reserve> handle(GetReserveByIdQuery query){
        return reserveRepository.findById(query.reserveId());
    }

}
