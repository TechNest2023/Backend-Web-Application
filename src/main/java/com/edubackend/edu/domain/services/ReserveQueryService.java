package com.edubackend.edu.domain.services;
import com.edubackend.edu.domain.model.aggregates.Reserve;
import com.edubackend.edu.domain.model.queries.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ReserveQueryService {
    List<Reserve> handle(GetStudentReserveQuery query);
    Optional<Reserve> handle(GetReserveByIdQuery query);
    List<Reserve> handle(GetAllReserveQuery query);
    List<Reserve> handle(GetSpecialistReserveQuery query);
    Optional<Reserve>handle(GetReserveByEduStudentRecordIdAndSpecialistIdQuery query);
}
