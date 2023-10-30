package com.edufocusbackend.edu.domain.model.entities;

import com.edufocusbackend.edu.domain.model.aggregates.Specialist;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Activity {

    @Id
    private Long id;

    private String title;
    private String description;
    private String  contenturl;

    public Long getId() {
        return id;
    }
}
