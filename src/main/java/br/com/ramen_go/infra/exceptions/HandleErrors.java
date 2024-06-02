package br.com.ramen_go.infra.exceptions;

import br.com.ramen_go.dtos.ErrorApiKeyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleErrors {
    @ExceptionHandler(ErrorApiKeyException.class)
    public ResponseEntity<ErrorApiKeyDto> handleErrorApiKeyException(ErrorApiKeyException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorApiKeyDto(ex.getMessage()));
    }




}
