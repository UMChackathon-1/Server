package com.PartyTonight.PartyTonight.global.error.exception;

import com.PartyTonight.PartyTonight.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class ExternalApiException extends RuntimeException {
    private final ErrorCode errorCode;

    public ExternalApiException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}