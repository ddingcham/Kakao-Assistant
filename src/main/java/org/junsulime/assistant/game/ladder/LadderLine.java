package org.junsulime.assistant.game.ladder;

public class LadderLine {
    String user;
    String result;

    public LadderLine(String user, String result) {
        this.user = user;
        this.result = result;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
