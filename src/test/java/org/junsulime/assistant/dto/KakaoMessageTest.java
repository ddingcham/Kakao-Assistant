package org.junsulime.assistant.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class KakaoMessageTest {

    @Test
    public void buildMessage() {
        KakaoMessageButton button = new KakaoMessageButton("label", "www.daum.net");
        KakaoPhoto photo = new KakaoPhoto("https://avatars1.githubusercontent.com/u/17852124?s=60&v=4",
                30, 30);

        KakaoMessage message = new KakaoMessage.Builder()
                .setText("text")
                .setMessageButton(button)
                .setPhoto(photo)
                .build();

        assertThat(message.getMessageButton()).isEqualTo(button);
        assertThat(message.getPhoto()).isEqualTo(photo);
        assertThat(message.getText()).isEqualTo("text");
    }

    @Test(expected = IllegalStateException.class)
    public void buildException() {
        new KakaoMessage.Builder().build();
    }

}