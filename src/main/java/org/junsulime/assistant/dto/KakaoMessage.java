package org.junsulime.assistant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class KakaoMessage {

    private String text;

    private KakaoPhoto photo;

    @JsonProperty("message_button")
    private KakaoMessageButton messageButton;

    private KakaoMessage() {

    }

    private KakaoMessage(String text, KakaoPhoto photo, KakaoMessageButton messageButton) {
        this.text = text;
        this.photo = photo;
        this.messageButton = messageButton;
    }

    public String getText() {
        return text;
    }

    public KakaoPhoto getPhoto() {
        return photo;
    }

    public KakaoMessageButton getMessageButton() {
        return messageButton;
    }

    public static KakaoMessage textMessage(String text) {
        KakaoMessage kakaoMessage = new KakaoMessage();
        kakaoMessage.text = text;
        return kakaoMessage;
    }

    public static class Builder {

        private String text;

        private KakaoPhoto photo;

        private KakaoMessageButton messageButton;

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setPhoto(KakaoPhoto photo) {
            this.photo = photo;
            return this;
        }

        public Builder setMessageButton(KakaoMessageButton messageButton) {
            this.messageButton = messageButton;
            return this;
        }

        private void checkValid() {
            if (Objects.isNull(text) && Objects.isNull(photo) && Objects.isNull(messageButton))
                throw new IllegalStateException("메세지에 text, photo, messageButton 중 하나는 들어가야 합니다.");
        }

        public KakaoMessage build() {
            checkValid();
            return new KakaoMessage(text, photo, messageButton);
        }
    }
}
