package io.github.arxtd.branchflow_api.infra.advice;

import io.github.arxtd.branchflow_api.infra.exception.ItemNotFoundException;
import io.github.arxtd.branchflow_api.infra.exception.NullFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    private ResponseEntity<String> resourceNotFound(ItemNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(NullFieldException.class)
    private ResponseEntity<String> nullFieldException(NullFieldException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}
