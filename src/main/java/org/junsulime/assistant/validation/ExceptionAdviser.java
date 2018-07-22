package org.junsulime.assistant.validation;

import org.junsulime.assistant.dto.KakaoMessage;
import org.junsulime.assistant.dto.KakaoResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviser {
    @ExceptionHandler(WrongMessageException.class)
    public KakaoResponse handleException(WrongMessageException e) {
        KakaoMessage message = new KakaoMessage.Builder()
                .setText(e.getMessage())
                .build();

        return new KakaoResponse(message);
    }
}
