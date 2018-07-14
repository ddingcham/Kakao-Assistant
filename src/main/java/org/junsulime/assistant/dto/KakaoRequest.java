package org.junsulime.assistant.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoRequest {
    @JsonProperty("user_key")
    private String userKey;

    private String type;

    private String content;

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "KakaoRequest{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
