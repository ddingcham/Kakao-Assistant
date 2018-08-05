package org.junsulime.assistant.function;

public class UserState {
    private String userKey;

    private String function;

    private int phase;

    private String extra;

    public UserState() {}

    public UserState(String userKey, String function, int phase, String extra) {
        this.userKey = userKey;
        this.function = function;
        this.phase = phase;
        this.extra = extra;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}
