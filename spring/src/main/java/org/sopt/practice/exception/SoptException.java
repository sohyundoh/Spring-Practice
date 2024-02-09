package org.sopt.practice.exception;

import org.sopt.practice.exception.message.ErrorMessage;

public class SoptException extends RuntimeException{

    public SoptException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}