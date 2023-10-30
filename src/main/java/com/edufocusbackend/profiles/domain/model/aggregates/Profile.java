package com.edufocusbackend.profiles.domain.model.aggregates;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Profile {
    private String firstName;
    private String lastName;
    private String email;
}
