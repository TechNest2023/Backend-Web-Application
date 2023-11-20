package com.edubackend.edu.domain.model.commands;
import com.edubackend.edu.domain.model.valueobjects.Age;
import com.edubackend.edu.domain.model.valueobjects.Career;
import com.edubackend.edu.domain.model.valueobjects.Image;
import com.edubackend.edu.domain.model.valueobjects.Topics;
import com.edubackend.profiles.domain.model.valueobjects.PersonName;

import java.util.List;

public record CreateSpecialistCommand(String fullName, Integer age, String career,
                                      String specialization, List<String> topic, String language,
                                      String nationality, String image) {
}
