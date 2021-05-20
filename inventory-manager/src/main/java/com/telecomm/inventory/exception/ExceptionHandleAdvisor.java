package com.telecomm.inventory.exception;

import com.google.inject.internal.cglib.reflect.$FastClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandleAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TowerException.class)
    public ResponseEntity<String> handleInputValidation(TowerException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
