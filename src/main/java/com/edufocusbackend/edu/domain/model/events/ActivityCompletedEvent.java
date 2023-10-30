package com.edufocusbackend.edu.domain.model.events;
import org.springframework.context.ApplicationEvent;

public final class ActivityCompletedEvent extends ApplicationEvent {
    private final Long reserveId;
    private final Long activityId;

    public ActivityCompletedEvent(Object source, Long reserveId, Long activityId){
        super(source);
        this.reserveId = reserveId;
        this.activityId = activityId;
    }
}
