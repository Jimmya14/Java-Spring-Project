package com.springboot.mongo.demo.project.movie;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieNotFoundException(Throwable cause) {
        super(cause);
    }

    public MovieNotFoundException(String message) {
        super(message);
    }

}
