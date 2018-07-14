package org.junsulime.assistant.api;

import org.junsulime.assistant.dto.KakaoKeyboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KakaoController {

    @GetMapping("/keyboard")
    public KakaoKeyboard hello() {
        return new KakaoKeyboard();
    }
}
