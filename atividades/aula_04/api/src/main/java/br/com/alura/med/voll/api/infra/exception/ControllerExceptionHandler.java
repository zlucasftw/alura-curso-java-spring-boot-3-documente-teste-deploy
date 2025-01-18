package br.com.alura.med.voll.api.infra.exception;

import br.com.alura.med.voll.api.dto.validation.ValidationExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBadRequest(MethodArgumentNotValidException exception) {
        var error = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(ValidationExceptionDTO::new).toList());
    }

}
