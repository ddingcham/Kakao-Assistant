package org.junsulime.assistant.api;

import org.junsulime.assistant.dto.KakaoKeyboard;
import org.junsulime.assistant.dto.KakaoMessage;
import org.junsulime.assistant.dto.KakaoRequest;
import org.junsulime.assistant.dto.KakaoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KakaoController {

    @GetMapping("/keyboard")
    public KakaoKeyboard hello() {
        return new KakaoKeyboard();
    }

    @PostMapping("/message")
    public KakaoResponse message(@RequestBody KakaoRequest request) {
        KakaoMessage message = new KakaoMessage.Builder()
                .setText(request.toString())
                .build();
        return new KakaoResponse(message);
    }
}
