package com.mintsoftwaresystems.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(String message) {
        super(message);
    }
}
