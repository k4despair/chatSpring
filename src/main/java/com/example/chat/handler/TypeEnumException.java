package com.example.chat.handler;

public class TypeEnumException extends Exception {
    public TypeEnumException() {
        super();
    }

    public TypeEnumException(String message) {
        super(message);
    }

    public TypeEnumException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeEnumException(Throwable cause) {
        super(cause);
    }
}
