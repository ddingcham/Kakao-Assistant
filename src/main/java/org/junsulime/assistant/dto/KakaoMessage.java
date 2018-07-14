package org.junsulime.assistant.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class KakaoMessage {

    private String text;

    private KakaoPhoto photo;

    @JsonAlias("message_button")
    private KakaoMessageButton messageButton;

    private KakaoMessage() {

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

    public class Builder {

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
            return message;
        }
    }
}
