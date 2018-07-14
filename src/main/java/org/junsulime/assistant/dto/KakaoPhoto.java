package org.junsulime.assistant.dto;

public class KakaoPhoto {
    private String url;
    private int width;
    private int height;

    public KakaoPhoto(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
