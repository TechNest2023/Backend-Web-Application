package com.edubackend.edu.interfaces.rest.resources;
import java.util.List;

public record CreateSpecialistResource (String fullname, Integer age, String career, String specialization,
                                        List<String> topics, String language, String nationality, String image){
}
