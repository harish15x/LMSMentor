package com.bridgelabz.lmsmentor.exception;

import com.bridgelabz.lmsmentor.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MentorExceptionHandler {

    @ExceptionHandler(MentorNotFoundException.class)
    public ResponseEntity<Response> handleHiringException(MentorNotFoundException he) {
        Response response = new Response();
        response.setErrorCode(400);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
