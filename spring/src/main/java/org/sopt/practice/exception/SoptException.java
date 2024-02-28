package org.sopt.practice.exception;

import lombok.Getter;
import org.sopt.practice.exception.message.ErrorMessage;

@Getter
public class SoptException extends RuntimeException{

    private final ErrorMessage errorMessage;
    public SoptException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}