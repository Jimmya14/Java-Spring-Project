package com.springboot.mongo.demo.project.movieList;

public class MovieListNotFoundException extends RuntimeException{
    
    public MovieListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieListNotFoundException(Throwable cause) {
        super(cause);
    }

    public MovieListNotFoundException(String message) {
        super(message);
    }
}
