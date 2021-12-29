package com.springboot.mongo.demo.project.MovieList;

public class OrderNotValidException extends RuntimeException {

    public OrderNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderNotValidException(Throwable cause) {
        super(cause);
    }

    public OrderNotValidException(String message) {
        super(message);
    }
}
