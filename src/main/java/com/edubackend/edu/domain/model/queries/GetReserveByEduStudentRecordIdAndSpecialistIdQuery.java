package com.edubackend.edu.domain.model.queries;

import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;

public record GetReserveByEduStudentRecordIdAndSpecialistIdQuery(EduStudentRecordId eduStudentRecordId, Long specialistId) {
}
