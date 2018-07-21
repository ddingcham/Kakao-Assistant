package org.junsulime.assistant.game.ladder;

import org.junsulime.assistant.validation.WrongMessageException;

import java.util.ArrayList;
import java.util.List;

public class LadderMapper {
    private List<LadderLine> lines = new ArrayList<>();

    public LadderMapper(String[] names, String[] results) {
        if (names.length != results.length)
            throw new WrongMessageException("사람 수와 결과 값의 수를 같게 입력해주세요.");

        for (int i = 0; i < names.length; i++) {
            lines.add(new LadderLine(names[i], results[i]));
        }
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
