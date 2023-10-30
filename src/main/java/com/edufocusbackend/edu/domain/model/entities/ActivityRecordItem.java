package com.edufocusbackend.edu.domain.model.entities;
import com.edufocusbackend.edu.domain.model.aggregates.Reserve;
import com.edufocusbackend.edu.domain.model.valueobjects.ActivityStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.util.Date;

@Entity
public class ActivityRecordItem {
    @Id
    private Long id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "reserve_id")
    private Reserve reserve;

    @Getter
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    private ActivityStatus status;

    private Date startedAt; // La fecha en la que el especialista creo la actividad
    private Date completedAt; // Fecha en que el estudiante completo la actividad

    public ActivityRecordItem(Reserve reserve, Activity activity){
        this.reserve = reserve;
        this.activity = activity;

        this.status = ActivityStatus.NOT_STARTED;
        this.startedAt = new Date();
    }

    public ActivityRecordItem(){ }

    public void complete(){
        this.status = ActivityStatus.COMPLETED;
        this.completedAt = new Date();
    }

    public  boolean isCompleted(){
        return this.status == ActivityStatus.COMPLETED;
    }
    public  boolean isNotStarted(){
        return this.status  == ActivityStatus.NOT_STARTED;
    }


}
