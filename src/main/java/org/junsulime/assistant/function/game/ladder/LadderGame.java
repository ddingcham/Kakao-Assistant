package org.junsulime.assistant.function.game.ladder;

public class LadderGame {
    private static final String SPLITTER = ",";

    private Ladder ladder;
    private LadderMapper ladderMapper;

    public LadderGame(String names, String results, int height, LadderGenerator generator) {
        ladderMapper = new LadderMapper(parseInput(names), parseInput(results));

        int row = ladderMapper.getLadderRow();
        ladder = generator.generate(height, row);
    }

    static String[] parseInput(String inputString) {
        String[] names = inputString.split(SPLITTER);
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
        return names;
    }

    public String play(String user) {
        return ladderMapper.getResult(play(ladderMapper.getUserRow(user)));
    }

    public int play(int start) {
        LadderPosition tmp;
        LadderPosition prevPosition = null;
        LadderPosition position = new LadderPosition(start, 0);

        while (!position.isGameEnd(ladder)) {
            tmp = position;
            position = position.updatePosition(ladder, prevPosition);
            prevPosition = tmp;
        }
        return position.getX();
    }

    public String getLadder() {
        return ladder.toString();
    }
}
