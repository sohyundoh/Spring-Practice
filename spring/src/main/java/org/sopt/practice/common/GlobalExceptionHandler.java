package org.sopt.practice.common;

import org.sopt.practice.common.dto.ErrorResponse;
import org.sopt.practice.exception.SoptException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    protected ResponseEntity<ErrorResponse> handleSoptException(SoptException e) {
        return ResponseEntity.internalServerError().body(ErrorResponse.of(e.getErrorMessage().getStatus(), e.getErrorMessage().getMessage()));
    }
}
