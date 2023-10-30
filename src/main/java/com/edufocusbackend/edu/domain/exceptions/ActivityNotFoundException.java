package com.edufocusbackend.edu.domain.exceptions;

public class ActivityNotFoundException extends RuntimeException{
    public ActivityNotFoundException(Long aLong){
        super("Activity wih id " + aLong + " not found");
    }
}
