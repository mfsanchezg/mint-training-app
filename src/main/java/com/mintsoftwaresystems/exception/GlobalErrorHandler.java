package com.mintsoftwaresystems.exception;

import org.springframework.http.*;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleAllException(Exception ex, WebRequest req){
        CustomErrorResponse res = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(EventNotFoundException.class)
    public ErrorResponse handleEventNotFoundException(EventNotFoundException ex, WebRequest req){
        return ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, ex.getMessage())
                .title("Event not found")
                .type(URI.create(req.getContextPath()))
                .build();
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<CustomErrorResponse> handleSQLException(SQLException ex, WebRequest req){
        CustomErrorResponse res = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }



}
