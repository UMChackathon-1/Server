package com.PartyTonight.PartyTonight.global.s3.exception;

import com.PartyTonight.PartyTonight.global.error.ErrorCode;
import com.PartyTonight.PartyTonight.global.error.exception.BusinessException;

public class InvalidFileExtensionException extends BusinessException {

    public InvalidFileExtensionException() {
        super(ErrorCode.INVALID_FILE_EXTENSION_ERROR);
    }
}

