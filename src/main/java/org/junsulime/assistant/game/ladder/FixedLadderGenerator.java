package org.junsulime.assistant.game.ladder;

public class FixedLadderGenerator implements LadderGenerator {
    private boolean[][] connected;

    public FixedLadderGenerator(boolean[][] connected) {
        this.connected = connected;
    }

    @Override
    public Ladder generate(int height, int row) {
        return new Ladder(connected);
    }
}
