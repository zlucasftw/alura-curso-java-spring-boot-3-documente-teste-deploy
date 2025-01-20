package br.com.alura.med.voll.api.dto.validation;

import org.springframework.validation.FieldError;

public record ValidationExceptionDTO (String field, String message){
    public ValidationExceptionDTO(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
