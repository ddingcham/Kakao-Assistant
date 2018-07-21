package org.junsulime.assistant.game.ladder;

public class Ladder {
    private static final int LADDER_WIDTH = 5;
    private static final int LADDER_EMPTY = ' ';
    private static final int LADDER_ROW = '-';
    private static final int LADDER_LINE = '|';
    private boolean[][] connected;

    public Ladder(boolean[][] connected) {
        this.connected = connected;
    }

    public boolean hasNoMoreLadder(int height) {
        return height >= connected.length;
    }

    public boolean canGoThisWay(int height, int x) {
        return isInBound(x) && connected[height][x];
    }

    private boolean isInBound(int x) {
        return 0 <= x && x < connected[0].length;
    }

    @Override
    public String toString() {
        int row = connected[0].length;
        StringBuilder builder = new StringBuilder();
        for (boolean[] connectedRow : connected) {
            builder.append(LADDER_LINE);
            for (int r = 0; r < row; r++) {
                builder.append(ladderRow(connectedRow[r]));
                builder.append(LADDER_LINE);
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    private StringBuilder ladderRow(boolean connected) {
        char ch = LADDER_EMPTY;
        if (connected)
            ch = LADDER_ROW;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < LADDER_WIDTH; i++) {
            builder.append(ch);
        }
        return builder;
    }
}
