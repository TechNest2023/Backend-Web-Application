package com.edufocusbackend.edu.domain.model.aggregates;

import com.edufocusbackend.edu.domain.model.events.ActivityCompletedEvent;
import com.edufocusbackend.edu.domain.model.valueobjects.ActivityRecord;
import com.edufocusbackend.edu.domain.model.valueobjects.ReserveStatus;
import com.edufocusbackend.edu.domain.model.valueobjects.StudentRecordId;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class Reserve extends AbstractAggregateRoot<Reserve> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Getter
    @Embedded
    private StudentRecordId studentRecordId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    private ReserveStatus status;

    @Embedded
    private ActivityRecord activityRecord;

    public Reserve(){ }

    public Reserve(StudentRecordId studentRecordId,Specialist specialist){
        this.studentRecordId = studentRecordId;
        this.specialist = specialist;
        this.status = ReserveStatus.REQUEST;
        this.activityRecord = new ActivityRecord();
    }

    public void confirm(){
        this.status = ReserveStatus.CONFIRMED;
        //this.adviceRecord.initializeAdiviceRecord(this);
    }

    public void reject() { // Rechazar
        this.status = ReserveStatus.REJECTED;
    }

    public void cancel() {
        this.status = ReserveStatus.CANCELLED;
    }

    public boolean isConfirmed() {
        return this.status == ReserveStatus.CONFIRMED;
    }

    public boolean isReject() {
        return this.status == ReserveStatus.REJECTED;
    }

    public String getStatus() {
        return this.status.name().toLowerCase();
    }

    public void completeActivity(Long activityId) {
        activityRecord.completeActivity(activityId);

        //Publicar un evento de actividad completada
        this.registerEvent(new ActivityCompletedEvent(this, this.getId(), activityId));
    }
}
