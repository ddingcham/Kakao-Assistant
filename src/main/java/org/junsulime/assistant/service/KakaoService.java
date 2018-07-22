package org.junsulime.assistant.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junsulime.assistant.dto.KakaoMessage;
import org.junsulime.assistant.dto.KakaoRequest;
import org.junsulime.assistant.dto.KakaoResponse;
import org.junsulime.assistant.function.Function;
import org.junsulime.assistant.function.UserState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

// <Service 사용의 의의>
//
// Transaction 단위의 method 처리
// 여러 controller 에서 사용하는 경우 중복코드 제거
@Service
public class KakaoService {

    private Logger logger = LoggerFactory.getLogger(KakaoService.class);

    private ObjectMapper mapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    // 모든 message handling 은 database 를 참조해야 하기 때문에
    // service 영역에서 handling method 를 만들었다.
    public KakaoResponse handleMessage(KakaoRequest request) throws IOException {
        logger.debug("redisTemplate: {}", redisTemplate);
//        BoundValueOperations<String, String> userOperation = redisTemplate.boundValueOps(request.getUserKey());
//        Optional<String> maybeUserData = Optional.ofNullable(userOperation.get());
//        if (maybeUserData.isPresent()) {
//
//        }

        return KakaoResponse.simpleTextMessage("Hello World");
    }
}
