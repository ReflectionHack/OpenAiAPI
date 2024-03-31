package edu.aubg.reflection.OpenAI.controllers;

import edu.aubg.reflection.OpenAI.models.ChatCompletionRequest;
import edu.aubg.reflection.OpenAI.models.ChatCompletionResponse;
import edu.aubg.reflection.OpenAI.models.promptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OpenAIRestController {

    private final RestTemplate restTemplate;

    @Autowired
    public OpenAIRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/hitOpenApi")
    public String getOpenAiResponse(@RequestBody promptDto prompt) {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", prompt.prompt());

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/evaluateSalesRevenue")
    public String evaluateSalesRevenue(@RequestBody String prompt) {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", "Evaluate all sales revenue");

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/evaluateMcdonaldsRevenue")
    public String evaluateMcdonaldsRevenue(@RequestBody String prompt) {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", "Evaluate McDonalds revenue");

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/evaluateKFCRevenue")
    public String evaluateKFCRevenue(@RequestBody String prompt) {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", "Evaluate KFC revenue");

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/evaluateMcDonaldsSocialMedia")
    public String evaluateMcDonaldsSocialMedia() {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", "Evaluate McDonald's social media presence, including percentages of activity for Facebook Pages, Twitter Handles, Instagram Accounts, YouTube Channels, and LinkedIn Accounts.");

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/evaluateKFCSocialMedia")
    public String evaluateKFCSocialMedia() {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", "Evaluate KFC's social media presence, including percentages of activity for Facebook Pages, Twitter Handles, Instagram Accounts, YouTube Channels, and LinkedIn Accounts.");

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/evaluateBurgerKingSocialMedia")
    public String evaluateBurgerKingSocialMedia() {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", "Evaluate Burger King's social media presence, including percentages of activity for Facebook Pages, Twitter Handles, Instagram Accounts, YouTube Channels, and LinkedIn Accounts.");

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/evaluateMcDonaldsMarketShare")
    public String evaluateMcDonaldsMarketShare() {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", "Evaluate McDonald's market share.");

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/evaluateKFCMarketShare")
    public String evaluateKFCMarketShare() {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", "Evaluate KFC's market share.");

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/evaluateBurgerKingMarketShare")
    public String evaluateBurgerKingMarketShare() {
        ChatCompletionRequest chatCompletionRequest
                = new ChatCompletionRequest("gpt-3.5-turbo", "Evaluate Burger King's market share.");

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequest,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/compareBusinessAnalytics")
    public String compareBusinessAnalytics(@RequestBody List<String> prompts) {
        List<ChatCompletionRequest> chatCompletionRequests = prompts.stream()
                .map(prompt -> new ChatCompletionRequest("gpt-3.5-turbo", prompt))
                .toList();

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                chatCompletionRequests,
                ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }

}

