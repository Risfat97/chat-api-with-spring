package com.sirtaf.chatapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Violation of data integrity")
public class NotSavedException extends RuntimeException {
    public NotSavedException() {
    }

    public NotSavedException(String message) {
        super(message);
    }

    public NotSavedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSavedException(Throwable cause) {
        super(cause);
    }

    public NotSavedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
