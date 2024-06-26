package edu.aubg.reflection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ReflectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReflectionApplication.class, args);
	}

	@Value("${spring.ai.openai.api-key}")
	private String openaiApiKey;

	@Bean
	public RestTemplate restTemplate() {
		System.out.println(openaiApiKey);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
			return execution.execute(request, body);
		});
		return restTemplate;
	}

}
