package org.junsulime.assistant.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junsulime.assistant.dto.KakaoRequest;
import org.junsulime.assistant.dto.KakaoResponse;
import org.junsulime.assistant.function.Function;
import org.junsulime.assistant.function.FunctionResult;
import org.junsulime.assistant.function.UserState;
import org.junsulime.assistant.validation.WrongMessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@Service
public class KakaoService {
    private Logger logger = LoggerFactory.getLogger(KakaoService.class);

    // TODO: instead of redisTemplate
    @Resource(name = "userDataMap")
    private HashMap<String, String> userDataMap;

    @Resource(name = "functionMap")
    private HashMap<String, Function> functionMap;

    @Resource(name = "objectMapper")
    private ObjectMapper objectMapper;

    public KakaoResponse handleMessage(KakaoRequest request) throws IOException {
        if (userDataMap.containsKey(request.getUserKey())) {
            return handleFunctionPlay(request);
        }
        return handleFunctionStart(request);
    }

    private KakaoResponse handleFunctionStart(KakaoRequest request) throws IOException {
        Function function = Optional.ofNullable(functionMap.get(request.getContent()))
                .orElseThrow(() -> new WrongMessageException(request.getUserKey(), "지원하지 않는 기능입니다."));
        FunctionResult result = function.start();

        UserState state = new UserState(request.getUserKey(), request.getContent(), result.getNextPhase(), result.getData());
        userDataMap.put(request.getUserKey(), objectMapper.writeValueAsString(state));

        return new KakaoResponse(result.getMessage());
    }

    private KakaoResponse handleFunctionPlay(KakaoRequest request) throws IOException {
        String data = userDataMap.get(request.getUserKey());
        UserState state = objectMapper.readValue(data, UserState.class);

        Function function = functionMap.get(state.getFunction());
        FunctionResult result = function.play(request.getContent(), state);

        if (result.getNextPhase() == Function.END_PHASE) {
            userDataMap.remove(request.getUserKey());
            return new KakaoResponse(result.getMessage());
        }

        state.setPhase(result.getNextPhase());
        state.setExtra(result.getData());

        userDataMap.put(request.getUserKey(), objectMapper.writeValueAsString(state));

        return new KakaoResponse(result.getMessage());
    }
}
