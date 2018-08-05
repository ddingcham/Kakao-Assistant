package org.junsulime.assistant.function;

import org.junsulime.assistant.dto.KakaoMessage;

public class FunctionResult {

    private int nextPhase;

    private String data;

    private KakaoMessage message;

    public FunctionResult(int nextPhase, String data, KakaoMessage message) {
        this.nextPhase = nextPhase;
        this.data = data;
        this.message = message;
    }

    public FunctionResult(int nextPhase, KakaoMessage message) {
        this.nextPhase = nextPhase;
        this.message = message;
    }

    public int getNextPhase() {
        return nextPhase;
    }

    public void setNextPhase(int nextPhase) {
        this.nextPhase = nextPhase;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public KakaoMessage getMessage() {
        return message;
    }

    public void setMessage(KakaoMessage message) {
        this.message = message;
    }
}
