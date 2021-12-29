package com.springboot.mongo.demo.project.MovieList;

import com.springboot.mongo.demo.project.Global.ErrorMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieListExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(MovieListNotFoundException exc) {

        ErrorMessage err = new ErrorMessage(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(OrderNotValidException exc) {

        ErrorMessage err = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
