package org.junsulime.assistant.function;

import java.util.Arrays;

public enum Function {
    LADDER_GAME("사다리게임");


    private String function;

    Function(String function) {
        this.function = function;
    }

    public static Function getFunction(String function) {
        return Arrays.stream(Function.values())
                .filter(f -> f.function.equals(function))
                .findFirst()
                .orElseThrow(NotSelectFunctionException::new);
    }

}
