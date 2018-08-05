package org.junsulime.assistant.validation;

public class WrongMessageException extends RuntimeException {

    private String userKey;

    public WrongMessageException(String userKey, String message) {
        super(message);
    }
}
