package com.edufocusbackend.edu.domain.model.queries;
import com.edufocusbackend.edu.domain.model.valueobjects.ProfileId;
import lombok.Data;


public record GetStudentByProfileIdQuery(ProfileId profileId) {
}
