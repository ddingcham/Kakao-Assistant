package org.junsulime.assistant.validation;

public class WrongMessageException extends RuntimeException {
    public WrongMessageException(String message) {
        super(message);
    }
}
