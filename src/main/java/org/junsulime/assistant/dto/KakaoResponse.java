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
}
