package com.example.chatgptbasedcookingingredients.Service;

import com.example.chatgptbasedcookingingredients.models.ChatGptMessage;
import com.example.chatgptbasedcookingingredients.models.ChatGptRequest;
import com.example.chatgptbasedcookingingredients.models.ChatGptResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service

public class ChatGptService {

    private final RestClient restClient;


    public ChatGptService(@Value("${app.chatgpt.api.url}") String url,
                          @Value("${app.chatgpt.api.key}") String apiKey,
                          @Value("${app.chatgpt.api.org}") String org) {

        restClient = RestClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("OpenAI-Organization", org)
                .build();
    }

    public String chatGpt(String message) {

        ChatGptRequest requestBody = new ChatGptRequest(List.of(new ChatGptMessage("user", message)), "gpt-3.5-turbo");

        ChatGptResponse response = restClient.post()
                .uri("/completions")
                .body(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ChatGptResponse.class);

        return response.choices().get(0).message().content();
    }

}
