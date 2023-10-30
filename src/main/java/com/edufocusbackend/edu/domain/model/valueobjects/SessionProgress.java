package com.edufocusbackend.edu.domain.model.valueobjects;
import jakarta.persistence.Embeddable;

@Embeddable
public record SessionProgress(Integer totalCompleteSesion, Integer totalActivities) {
    public SessionProgress(){
        this(0,0);
    }

    public SessionProgress {
        if (totalCompleteSesion < 0) {
            throw new IllegalArgumentException("Total completes sesions cannot be negative");
        }

        if (totalActivities < 0) {
            throw new IllegalArgumentException("Total activities cannot be negative");
        }
    }

    public SessionProgress incrementTotalCompleteSesions(){
        return new SessionProgress(totalCompleteSesion + 1 , totalActivities);
    }
    public SessionProgress incrementTotalActivities(){
        return new SessionProgress(totalCompleteSesion , totalActivities + 1);
    }
}
