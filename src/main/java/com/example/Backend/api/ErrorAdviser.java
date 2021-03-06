package com.example.Backend.api;

import com.example.Backend.exception.BaseException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorAdviser {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorRespond> handleBaseException(BaseException e) {
        ErrorRespond response = new ErrorRespond();
        response.setError(e.getMessage());
        response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<ErrorRespond>(response, HttpStatus.EXPECTATION_FAILED);
    }

    // Inner class variable
    @Data
    public static class ErrorRespond {

        private LocalDateTime timestamp = LocalDateTime.now();

        private int status;

        private String error;

    }

}
