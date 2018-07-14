package org.junsulime.assistant.api;

import org.junsulime.assistant.dto.KakaoKeyboard;
import org.junsulime.assistant.dto.KakaoMessage;
import org.junsulime.assistant.dto.KakaoRequest;
import org.junsulime.assistant.dto.KakaoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
