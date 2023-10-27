package com.edufocus.edufocus.learning.domain.aggregates;

import com.edufocus.edufocus.learning.domain.valueobject.EspecialistId;
import com.edufocus.edufocus.learning.domain.valueobject.StudentId;
import com.edufocus.edufocus.shared.domain.model.entities.AuditableModel;
import com.edufocus.edufocus.learning.domain.valueobject.ProfileId;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Especialist extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(name = "student_id")
    private EspecialistId  especialistId;

    @Embedded
    private ProfileId profileId;

}
