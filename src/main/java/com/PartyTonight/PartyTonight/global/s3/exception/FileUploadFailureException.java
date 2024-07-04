package com.PartyTonight.PartyTonight.global.s3.exception;

import com.PartyTonight.PartyTonight.global.error.ErrorCode;
import com.PartyTonight.PartyTonight.global.error.exception.ExternalApiException;

public class FileUploadFailureException extends ExternalApiException {

    public FileUploadFailureException() {
        super(ErrorCode.FILE_UPLOAD_FAILURE_ERROR);
    }
}
