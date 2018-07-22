package org.junsulime.assistant.function.game.ladder;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private LadderPosition position;
    private Ladder ladder;

    @Before
    public void setUp() throws Exception {
        position = new LadderPosition(3, 0);
        boolean[][] connected = new boolean[3][4];
        connected[1][2] = true;
        connected[2][3] = true;
        ladder = new Ladder(connected);
    }

    @Test
    public void isGameEnd() {
        position.isGameEnd(ladder);
    }

    @Test
    public void updatePosition() {
        assertThat(position.updatePosition(ladder, null)).isEqualTo(new LadderPosition(3, 1));
    }
}