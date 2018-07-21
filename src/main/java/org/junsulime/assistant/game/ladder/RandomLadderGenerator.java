package org.junsulime.assistant.game.ladder;

import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {
    private Random random = new Random();

    private boolean[] generateRandomRow(int column) {
        boolean prev = false;
        boolean[] connectedRow = new boolean[column];

        for (int i = 0; i < column; i++) {
            connectedRow[i] = generateRandomConnection(prev);
            prev = connectedRow[i];
        }
        return connectedRow;
    }

    private boolean generateRandomConnection(boolean prevConnect) {
        if (prevConnect)
            return false;
        return random.nextBoolean();
    }

    @Override
    public Ladder generate(int height, int row) {
        boolean[][] connected = new boolean[height][];
        for (int i = 0; i < height; i++) {
            connected[i] = generateRandomRow(row-1);
        }
        return new Ladder(connected);
    }
}
