package org.junsulime.assistant.dto;

public class KakaoResponse {

    private KakaoMessage message;

    private KakaoKeyboard keyboard;

    public KakaoResponse(KakaoMessage message) {
        this(message, null);
    }

    public KakaoResponse(KakaoMessage message, KakaoKeyboard keyboard) {
        this.message = message;
        this.keyboard = keyboard;
    }

    public KakaoMessage getMessage() {
        return message;
    }

    public KakaoKeyboard getKeyboard() {
        return keyboard;
    }
}
