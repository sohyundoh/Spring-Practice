package org.sopt.practice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private int status;
    private String message;

    public static ErrorResponse of(int status, String message) {
        return new ErrorResponse(status, message);
    }
}
