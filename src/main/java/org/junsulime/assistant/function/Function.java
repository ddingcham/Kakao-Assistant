package org.junsulime.assistant.function;

import org.junsulime.assistant.dto.KakaoMessage;
import org.junsulime.assistant.validation.WrongMessageException;

import java.io.IOException;
import java.util.Arrays;

public abstract class Function {
    public static final int INIT_PHASE = 100;
    public static final int END_PHASE = 101;
    public static final int INVALID_PHASE = -1;

    public FunctionResult start() throws IOException {
        return startFunction();
    }

    public FunctionResult play(String userInput, UserState state) throws IOException {
        try {
            return playFunction(userInput, state);
        }
        catch (FunctionException e) {
            throw new WrongMessageException(state.getUserKey(), e.getMessage());
        }
    }

    protected abstract FunctionResult startFunction() throws IOException;

    protected abstract FunctionResult playFunction(String userInput, UserState state) throws IOException, FunctionException;
}