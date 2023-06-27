package org.example.mysql;

public class SQLRuntimeException extends RuntimeException {

    public SQLRuntimeException() {
    }

    public SQLRuntimeException(String message) {
        super(message);
    }

    public SQLRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
