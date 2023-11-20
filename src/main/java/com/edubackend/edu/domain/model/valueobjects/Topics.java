package com.edubackend.edu.domain.model.valueobjects;
import jakarta.persistence.Embeddable;

@Embeddable
public record Topics(String topic) {

    public Topics(){
        this(null);
    }

    public Topics{
        if (topic == null || topic.isBlank()){
            throw new IllegalArgumentException("Topics cannot be null or blank");
        }
    }

    public String getTopics(){
        return topic;
    }
}
