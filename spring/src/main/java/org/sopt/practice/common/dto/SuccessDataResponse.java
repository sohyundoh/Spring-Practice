package org.sopt.practice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sopt.practice.exception.message.SuccessMessage;

@Getter
public class SuccessDataResponse<T> extends SuccessStatusResponse {
    private T data;

    private SuccessDataResponse(SuccessMessage successMessage, T data) {
        super(successMessage.getStatus(), successMessage.getMessage());
        this.data = data;
    }
    public static <T> SuccessDataResponse<T> of(SuccessMessage successMessage, T data) {
        return new SuccessDataResponse<T>(successMessage, data);
    }
}
