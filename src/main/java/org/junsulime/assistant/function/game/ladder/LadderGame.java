package org.junsulime.assistant.function.game.ladder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junsulime.assistant.dto.KakaoMessage;
import org.junsulime.assistant.function.Function;
import org.junsulime.assistant.function.FunctionException;
import org.junsulime.assistant.function.FunctionResult;
import org.junsulime.assistant.function.UserState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LadderGame extends Function {
    private static final Logger log = LoggerFactory.getLogger(LadderGame.class);

    public static final String TAG = "사다리게임";

    private static final int NAME_PHASE = 0;
    private static final int RESULT_PHASE = 1;

    private static final int LADDER_HEIGHT = 6;

    private static final String SPLITTER = ",";

    // TODO: change it into bean objectMapper
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public FunctionResult startFunction() throws IOException {
        return initPhase();
    }

    public FunctionResult playFunction(String userInput, UserState state) throws IOException, FunctionException {
        log.debug("play is called with phase: {}", state.getPhase());
        switch (state.getPhase()) {
            case NAME_PHASE:
                return namePhase(userInput);
            case RESULT_PHASE:
                return resultPhase(userInput, state.getExtra());
        }
        throw new RuntimeException();
    }

    private FunctionResult initPhase() {
        log.debug("initPhase is called");

        return new FunctionResult(
                NAME_PHASE, TAG,
                KakaoMessage.textMessage("사다리타기를 할 사람들을 입력해주세요 (사람 간의 구분은 , 로 합니다.)")
        );
    }

    private FunctionResult namePhase(String userInput) throws IOException {
        log.debug("namePhase is called");
        String[] names = parseInput(userInput);

        LadderGameData gameData = new LadderGameData();
        gameData.names = names;

        String data = objectMapper.writeValueAsString(gameData);

        return new FunctionResult(
                RESULT_PHASE, data,
                KakaoMessage.textMessage("사다리타기의 결과를 입력해주세요 (결과 값의 구분은 , 로 합니다.)")
        );
    }

    private FunctionResult resultPhase(String userInput, String data) throws IOException, FunctionException {
        log.debug("resultPhase is called");
        LadderGameData gameData = objectMapper.readValue(data, LadderGameData.class);

        String[] names = gameData.names;
        String[] results = parseInput(userInput);

        LadderGenerator generator = new RandomLadderGenerator();
        LadderMapper ladderMapper = LadderMapper.of(names, results);
        Ladder ladder = generator.generate(LADDER_HEIGHT, ladderMapper.getLadderRow());

        return new FunctionResult(
                Function.END_PHASE,
                KakaoMessage.textMessage(ladder.toString())
        );
    }

    static String[] parseInput(String inputString) {
        String[] names = inputString.split(SPLITTER);
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
        return names;
    }

    public static class LadderGameData {
        private String[] names;

        // getter and setter for jackson library.

        public void setNames(String[] names) {
            this.names = names;
        }

        public String[] getNames() {
            return names;
        }
    }

//    static int play(int start) {
//        LadderPosition tmp;
//        LadderPosition prevPosition = null;
//        LadderPosition position = new LadderPosition(start, 0);
//
//        while (!position.isGameEnd(ladder)) {
//            tmp = position;
//            position = position.updatePosition(ladder, prevPosition);
//            prevPosition = tmp;
//        }
//        return position.getX();
//    }
}
