package org.junsulime.assistant.api;

import org.junsulime.assistant.dto.KakaoKeyboard;
import org.junsulime.assistant.dto.KakaoMessage;
import org.junsulime.assistant.dto.KakaoRequest;
import org.junsulime.assistant.dto.KakaoResponse;
import org.junsulime.assistant.function.Function;
import org.junsulime.assistant.function.NotSelectFunctionException;
import org.junsulime.assistant.service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class KakaoController {

    @Autowired
    private KakaoService kakaoService;

    @GetMapping("/keyboard")
    public KakaoKeyboard hello() {
        return new KakaoKeyboard();
    }

    @PostMapping("/message")
    public KakaoResponse message(@RequestBody KakaoRequest request) throws IOException {
        return kakaoService.handleMessage(request);
    }

    @PostMapping("/friend")
    public void addFriend(@RequestBody KakaoRequest request) {

    }

    @DeleteMapping("/friend/{user_key}")
    public void deleteFriend(@PathVariable(name = "user_key") String userKey) {

    }

    @DeleteMapping("/chat_room/{user_key}")
    public void exitRoom(@PathVariable(name = "user_key") String userKey) {

    }
}
