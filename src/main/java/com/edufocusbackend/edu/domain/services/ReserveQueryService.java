package com.edufocusbackend.edu.domain.services;
import com.edufocusbackend.edu.domain.model.aggregates.Reserve;
import com.edufocusbackend.edu.domain.model.queries.GetReserveByIdQuery;
import com.edufocusbackend.edu.domain.model.queries.GetStudentReserveQuery;
import java.util.List;
import java.util.Optional;

public interface ReserveQueryService {
    List<Reserve> handle(GetStudentReserveQuery query);
    Optional<Reserve> handle(GetReserveByIdQuery query);
}
