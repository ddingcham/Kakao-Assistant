package org.junsulime.assistant.function.game.ladder;


import org.junsulime.assistant.function.FunctionException;

import java.util.ArrayList;
import java.util.List;

public class LadderMapper {
    private List<LadderLine> lines = new ArrayList<>();

    private LadderMapper(String[] names, String[] results) {
        for (int i = 0; i < names.length; i++) {
            lines.add(new LadderLine(names[i], results[i]));
        }
    }

    public static LadderMapper of(String[] names, String[] results) throws FunctionException {
        if (names.length != results.length)
            throw new FunctionException("사람 수와 결과 값의 수를 같게 입력해주세요.");

        return new LadderMapper(names, results);
    }

    public int getLadderRow() {
        return lines.size();
    }

    public int getUserRow(String user) {
        LadderLine line = lines.stream().filter(l -> l.getUser().equals(user)).findFirst().orElseThrow(RuntimeException::new);
        return lines.indexOf(line);
    }

    public String getResult(int resultIndex) {
        return lines.get(resultIndex).getResult();
    }
}
