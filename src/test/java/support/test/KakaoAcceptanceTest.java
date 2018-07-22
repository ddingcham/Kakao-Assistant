package support.test;

import org.junit.runner.RunWith;
import org.junsulime.assistant.dto.KakaoRequest;
import org.junsulime.assistant.dto.KakaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class KakaoAcceptanceTest {
    private static final String DEFAULT_USER = "junsulime";

    @Autowired
    private TestRestTemplate template;

    public KakaoResponse sendText(String text) {
        KakaoRequest request = new KakaoRequest();
        request.setUserKey(DEFAULT_USER);
        request.setText(text);
        ResponseEntity<KakaoResponse> response = template.postForEntity("/message", request, KakaoResponse.class);
        return response.getBody();
    }
}