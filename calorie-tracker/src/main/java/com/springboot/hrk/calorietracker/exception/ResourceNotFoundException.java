package com.springboot.hrk.calorietracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Entity not Found");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
