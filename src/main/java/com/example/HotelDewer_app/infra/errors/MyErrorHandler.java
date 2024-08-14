package com.example.HotelDewer_app.infra.errors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.xml.bind.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class MyErrorHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> myValidationExceptionHandler(ValidationException e){
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode response = objectMapper.createObjectNode();

        response.put("code", e.getErrorCode());
        response.put("message", e.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MyIntegrityValidation.class)
    public ResponseEntity<?> myIntegrityValidationHandler(MyIntegrityValidation e){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();

        response.put("code", "400");
        response.put("message", e.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> myMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        List<errorDTO> errorList = e.getFieldErrors().stream().map(errorDTO::new).toList();

        return ResponseEntity.badRequest().body(errorList);
    }

    public record errorDTO(String campo, String error){
        public errorDTO(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
