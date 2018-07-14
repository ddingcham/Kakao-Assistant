package org.junsulime.assistant.dto;

public class KakaoMessageButton {
    private String label;
    private String url;

    public KakaoMessageButton(String label, String url) {
        this.label = label;
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public String getUrl() {
        return url;
    }
}
