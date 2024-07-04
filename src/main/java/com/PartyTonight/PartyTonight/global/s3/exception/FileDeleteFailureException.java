package com.PartyTonight.PartyTonight.global.s3.exception;

import com.PartyTonight.PartyTonight.global.error.ErrorCode;
import com.PartyTonight.PartyTonight.global.error.exception.ExternalApiException;

public class FileDeleteFailureException extends ExternalApiException {

    public FileDeleteFailureException() {
        super(ErrorCode.FILE_DELETE_FAILURE_ERROR);
    }
}