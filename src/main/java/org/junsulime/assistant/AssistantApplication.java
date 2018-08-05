package org.junsulime.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"org.junsulime.assistant"})
public class AssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssistantApplication.class, args);
	}
}
