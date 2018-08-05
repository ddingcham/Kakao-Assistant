package org.junsulime.assistant.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junsulime.assistant.function.Function;
import org.junsulime.assistant.function.game.ladder.LadderGame;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;

@Profile(value = {"develop", "product"})
@Configuration
@EnableCaching
public class AssistantConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public HashMap<String, String> userDataMap() {
        return new HashMap<>();
    }

    @Bean
    public HashMap<String, Function> functionMap() {
        HashMap<String, Function> functionMap = new HashMap<>();
        functionMap.put(LadderGame.TAG, new LadderGame());

        return functionMap;
    }


    @Profile("test")
    @Configuration
    @EnableCaching
    public class AssistantTestConfig {

    }
}
