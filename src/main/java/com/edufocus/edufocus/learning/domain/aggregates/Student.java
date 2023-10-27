package com.edufocus.edufocus.learning.domain.aggregates;

import com.edufocus.edufocus.learning.domain.valueobject.ActivitiesProgress;
import com.edufocus.edufocus.learning.domain.valueobject.ProfileId;
import com.edufocus.edufocus.learning.domain.valueobject.StudentId;
import com.edufocus.edufocus.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded()
    @Column(name = "student_id")
    private StudentId studentId;

    @Embedded
    private ProfileId profileId;

    @Embedded
    private ActivitiesProgress activitiesProgress;


    public Student() {
        this.studentId = new StudentId();
        this.activitiesProgress = new ActivitiesProgress();
    }

    public Student(Long profileId) {
        this();
        this.profileId = new ProfileId(profileId);
    }

    public void updateTotalSessionsCompleted() {
        this.activitiesProgress = this.activitiesProgress.incrementTotalCompleteSessions();
    }

    public void updateTotalActivitiesCompleted() {
        this.activitiesProgress = this.activitiesProgress.incrementTotalActiviesComplete();
    }
    public void updateTotalActivitiesPending() {
        this.activitiesProgress = this.activitiesProgress.incrementTotalActiviesPending();
    }
}
