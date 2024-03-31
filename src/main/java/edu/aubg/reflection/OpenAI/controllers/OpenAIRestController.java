package edu.aubg.reflection.OpenAI.controllers;

import edu.aubg.reflection.OpenAI.models.ChatCompletionRequest;
import edu.aubg.reflection.OpenAI.models.ChatCompletionResponse;
import edu.aubg.reflection.OpenAI.models.promptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OpenAIRestController {

    private final RestTemplate restTemplate;

    @Autowired
    public OpenAIRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/hitOpenApi")
    public String getOpenAiResponse(@RequestBody promptDto prompt){
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", prompt.prompt());

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

}