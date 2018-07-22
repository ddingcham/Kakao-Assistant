package org.junsulime.assistant.function.game.ladder;

import org.junit.Before;
import org.junit.Test;
import org.junsulime.assistant.validation.WrongMessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class LadderGameTest {
    private Logger logger = LoggerFactory.getLogger(LadderGameTest.class);

    private LadderGenerator fixedLadderGenerator;
    private LadderGenerator randomLadderGenerator;

    @Before
    public void setUp() throws Exception {
        fixedLadderGenerator = new FixedLadderGenerator(
                new boolean[][] {
                        {true, false, true},
                        {false, true, false},
                        {true, false, false},
                }
        );
        randomLadderGenerator = new RandomLadderGenerator();
    }

    @Test
    public void ladderPlay() {
        LadderGame ladderGame = new LadderGame("a, b, c, d", "1, 2, 3, 4", 3, fixedLadderGenerator);
        assertThat(ladderGame.play(0)).isEqualTo(2);
        assertThat(ladderGame.play(1)).isEqualTo(1);
        assertThat(ladderGame.play(2)).isEqualTo(3);
        assertThat(ladderGame.play(3)).isEqualTo(0);
    }

    @Test
    public void ladderUserPlay() {
        LadderGame ladderGame = new LadderGame("a, b, c, d", "1, 2, 3, 4", 3, fixedLadderGenerator);
        assertThat(ladderGame.play("a")).isEqualTo("3");
        assertThat(ladderGame.play("b")).isEqualTo("2");
        assertThat(ladderGame.play("c")).isEqualTo("4");
        assertThat(ladderGame.play("d")).isEqualTo("1");
    }

    @Test(expected = WrongMessageException.class)
    public void ladderInitException() {
        new LadderGame("b, c, d", "1, 2, 3, 4", 3, fixedLadderGenerator);
    }

    @Test
    public void parseInput() {
        String inputString = "junsu, seon-hwa, google";
        assertThat(LadderGame.parseInput(inputString)).isEqualTo(
                new String[] {
                        "junsu",
                        "seon-hwa",
                        "google"
                }
        );
    }

    @Test
    public void test() {
        LadderGame ladderGame = new LadderGame("junsu, seonhwa, workhard", "1, 2, 3", 100, randomLadderGenerator);
        List<Integer> results = new ArrayList<>();
        results.add(ladderGame.play(0));
        results.add(ladderGame.play(1));
        results.add(ladderGame.play(2));

        logger.debug("\n{}", ladderGame.getLadder());
        logger.debug("game result: {}", results);
        assertThat(results.stream().distinct().count()).isEqualTo(results.size());
    }
}