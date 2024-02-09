package org.sopt.practice.exception;

import org.sopt.practice.exception.message.ErrorMessage;

public class NotFoundException extends SoptException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
