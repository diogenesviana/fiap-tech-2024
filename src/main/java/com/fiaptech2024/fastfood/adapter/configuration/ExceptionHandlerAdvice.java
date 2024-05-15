package com.fiaptech2024.fastfood.adapter.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fiaptech2024.fastfood.core.services.exception.RegraDeNegocioException;
import com.fiaptech2024.fastfood.core.services.exception.EntityNotFoundException;


@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<String> handleRegraDeNegocioException(RegraDeNegocioException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotfound(EntityNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
        public  ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.notFound().build();
    }    

}