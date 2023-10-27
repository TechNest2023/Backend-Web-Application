package com.edufocus.edufocus.learning.domain.valueobject;

public record ActivitiesProgress(int TotalCompleteSessions, int TotalActiviesComplete, int TotalActiviesPending) {
    public ActivitiesProgress {
        if (TotalCompleteSessions <0) {
            throw new IllegalArgumentException("ActivitiesProgress TotalCompleteSessions cannot be negative");
        }
        if (TotalActiviesComplete <0) {
            throw new IllegalArgumentException("ActivitiesProgress TotalActiviesComplete cannot be negative");
        }
        if (TotalActiviesPending <0) {
            throw new IllegalArgumentException("ActivitiesProgress TotalActiviesPending cannot be negative");
        }
    }

    public ActivitiesProgress(){
        this(0,0,0);
    }
    public ActivitiesProgress incrementTotalCompleteSessions(){
        return new ActivitiesProgress(TotalCompleteSessions +1 , TotalActiviesComplete, TotalActiviesPending);
    }
    public ActivitiesProgress incrementTotalActiviesComplete(){
        return new ActivitiesProgress(TotalCompleteSessions , TotalActiviesComplete + 1, TotalActiviesPending);
    }
    public ActivitiesProgress incrementTotalActiviesPending(){
        return new ActivitiesProgress(TotalCompleteSessions , TotalActiviesComplete, TotalActiviesPending + 1);
    }
}
