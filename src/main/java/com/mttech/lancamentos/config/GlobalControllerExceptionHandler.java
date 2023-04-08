package com.mttech.lancamentos.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ErrorMessage> badRequest(IllegalArgumentException ex) {
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
                ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }
}
