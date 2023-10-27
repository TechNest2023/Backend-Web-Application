package com.edufocus.edufocus.profiles.domain.model.valueobjects;

public record Password(String password) {
    public Password(){
        this(null);
    }
}
