package com.sirtaf.chatapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleUserDataValidation(MethodArgumentNotValidException e) {
        List errors = e.getFieldErrors().stream()
                .map(errorField -> {
                    Map<String, String> hashMap = new HashMap<>();
                    hashMap.put(errorField.getField(), errorField.getDefaultMessage());

                    return hashMap;
                })
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errors);
    }
}
