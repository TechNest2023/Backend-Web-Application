package com.edubackend.edu.domain.exceptions;

public class SpecialistNotFoundException extends RuntimeException{
    public SpecialistNotFoundException(Long aLong){
        super("Specialist wih id " + aLong + " not found");
    }
}
