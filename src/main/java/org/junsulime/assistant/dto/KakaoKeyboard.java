package org.junsulime.assistant.dto;

import java.util.List;

public class KakaoKeyboard {
    private static final String KEYBOARD_TEXT = "text";
    private static final String KEYBOARD_BUTTON = "button";

    private String type;

    private List<String> buttons;

    public KakaoKeyboard() {
        type = KEYBOARD_TEXT;
    }

    public KakaoKeyboard(List<String> buttons) {
        type = KEYBOARD_BUTTON;
        buttons = buttons;
    }

    public String getType() {
        return type;
    }

    public List<String> getButtons() {
        return buttons;
    }
}
