package com.myTodoApplication.TodoApplication.exception;

import com.myTodoApplication.TodoApplication.utility.response.ErrorResponse;
import com.myTodoApplication.TodoApplication.utility.response.Response;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Response> handleConstraintViolation(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations().stream()
                .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                .collect(Collectors.joining(", "));
        log.error(message);
        return ResponseEntity.badRequest().body(
                new ErrorResponse(HttpStatus.BAD_REQUEST.value(), false, message)
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Response> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String message = "Data integrity violation: " + ex.getMostSpecificCause().getMessage();
        log.error(message);
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        false,
                        message
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleAllExceptions(Exception ex) {
        String message = "Unexpected server error: " + ex.getMessage();
        log.error(message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        false,
                        message
                )
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response> handleJsonParseException(HttpMessageNotReadableException ex) {
        String message = "Invalid request format: " + ex.getMostSpecificCause().getMessage();
        log.error(message);
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        false,
                        message
                )
        );
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Response> handleResponseStatusException(ResponseStatusException ex) {
        String message = ex.getReason() != null ? ex.getReason() : "Unexpected error";
        log.error(message);
        return ResponseEntity.status(ex.getStatusCode()).body(
                new ErrorResponse(
                        ex.getStatusCode().value(),
                        false,
                        message
                )
        );
    }
}
