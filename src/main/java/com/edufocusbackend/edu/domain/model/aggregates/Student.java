package com.edufocusbackend.edu.domain.model.aggregates;
import com.edufocusbackend.edu.domain.model.valueobjects.SessionProgress;
import com.edufocusbackend.edu.domain.model.valueobjects.ProfileId;
import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;
import com.edufocusbackend.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(name = "student_id")
    private StudentRecordId studentRecordId;

    @Embedded
    private ProfileId profileId;

    @Embedded
    private SessionProgress sessionProgress;

    public Student(){
        this.studentRecordId = new StudentRecordId();
        this.sessionProgress = new SessionProgress();
    }

    public Student(long profileId){
        this();
        this.profileId = new ProfileId(profileId);
    }

    public void updateSesionCompleted() { // Incrementa el número de sesiones completadas
        this.sessionProgress = this.sessionProgress.incrementTotalCompleteSesions();
    }

    public void updateActivityCompleted() { // Incrementa el número de actividades completadas
        this.sessionProgress = this.sessionProgress.incrementTotalActivities();
    }

    public String getStudentRecordId() {
        return this.studentRecordId.studentRecordId();
    }

    public Long getProfileId() {
        return  this.profileId.profileId();
    }
}
