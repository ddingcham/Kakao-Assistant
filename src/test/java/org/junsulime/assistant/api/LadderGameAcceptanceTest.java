package org.junsulime.assistant.api;

import org.junit.Test;
import org.junsulime.assistant.dto.KakaoResponse;
import support.test.KakaoAcceptanceTest;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameAcceptanceTest extends KakaoAcceptanceTest {

    @Test
    public void ladderGame() {
        KakaoResponse response;
        response = sendText("사다리게임");
        assertThat(response.getMessage().getText()).isEqualTo("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        response = sendText("a, b, c");
        assertThat(response.getMessage().getText()).isEqualTo("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        response = sendText("꽝, 500, 300");
        assertThat(response.getMessage().getText()).isEqualTo("최대 사다리 높이는 몇 개인가요?");
        response = sendText("3");
        assertThat(response.getMessage().getText()).hasLineCount(3+1);
        assertThat(response.getMessage().getText()).contains("결과를 보고 싶은 사람은?");

        response = sendText("a");
        assertThat(response.getMessage().getText()).contains("실행 결과");
        assertThat(response.getMessage().getText()).contains("결과를 보고 싶은 사람은?");
        response = sendText("모두");
        assertThat(response.getMessage().getText()).doesNotContain("결과를 보고 싶은 사람은?");
    }
}
