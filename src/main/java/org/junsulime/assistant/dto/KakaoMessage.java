package org.junsulime.assistant.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class KakaoMessage {

    private String text;

    private KakaoPhoto photo;

    @JsonProperty("message_button")
    private KakaoMessageButton messageButton;

    private KakaoMessage() {

    }

    private void checkValid() {
        if (Objects.isNull(text) && Objects.isNull(photo) && Objects.isNull(messageButton))
            throw new IllegalStateException("메세지에 text, photo, messageButton 중 하나는 들어가야 합니다.");
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

    public static class Builder {

        private KakaoMessage message;

        public Builder() {
            message = new KakaoMessage();
        }

        public Builder setText(String text) {
            message.text = text;
            return this;
        }

        public Builder setPhoto(KakaoPhoto photo) {
            message.photo = photo;
            return this;
        }

        public Builder setMessageButton(KakaoMessageButton messageButton) {
            message.messageButton = messageButton;
            return this;
        }

        public KakaoMessage build() {
            message.checkValid();
            return message;
        }
    }
}
