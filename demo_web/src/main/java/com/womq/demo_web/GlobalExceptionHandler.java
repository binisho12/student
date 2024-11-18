package com.womq.demo_web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<String> handleMethodNotAllowed(MethodNotAllowedException ex) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("This method is not allowed for the requested path.");
    }

}

