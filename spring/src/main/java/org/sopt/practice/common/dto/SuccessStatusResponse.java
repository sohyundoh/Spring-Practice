package org.sopt.practice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sopt.practice.exception.message.SuccessMessage;

@Getter
@AllArgsConstructor
public class SuccessStatusResponse {

    private int status;
    private String message;

    public static SuccessStatusResponse of(SuccessMessage successMessage) {
        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }
}
