package org.junsulime.assistant.game.ladder;

import java.util.Objects;

public class LadderPosition {
    private int x;
    private int height;

    public LadderPosition(int x, int height) {
        this.x = x;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public boolean isGameEnd(Ladder ladder) {
        return ladder.hasNoMoreLadder(height);
    }

    public LadderPosition updatePosition(Ladder ladder, LadderPosition prevPosition) {
        LadderPosition position = new LadderPosition(x, height);

        if (mustGoDownward(prevPosition)) {
            position.height++;
            return position;
        }
        else if (ladder.canGoThisWay(height, x-1)) {
            position.x--;
            return position;
        }
        else if (ladder.canGoThisWay(height, x)) {
            position.x++;
            return position;
        }
        position.height++;
        return position;
    }

    private boolean mustGoDownward(LadderPosition prevPosition) {
        return !Objects.isNull(prevPosition) && prevPosition.isSameHeight(height);
    }

    private boolean isSameHeight(int height) {
        return this.height == height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPosition position = (LadderPosition) o;
        return x == position.x &&
                height == position.height;
    }
}
