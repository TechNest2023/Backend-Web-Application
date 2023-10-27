package com.edufocus.edufocus.learning.domain.aggregates;

import com.edufocus.edufocus.learning.domain.valueobject.EspecialistId;
import com.edufocus.edufocus.learning.domain.valueobject.StudentId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private StudentId studentId;

    private EspecialistId especialistId;

}
