package org.junsulime.assistant.dto;

public class KakaoResponse {

    private KakaoMessage message;

    private KakaoKeyboard keyboard;

    // default constructor for java bean
    public KakaoResponse() {

    }

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

    public static KakaoResponse simpleTextMessage(String text) {
        KakaoMessage message = new KakaoMessage.Builder()
                .setText(text)
                .build();
        return new KakaoResponse(message);
    }
}
