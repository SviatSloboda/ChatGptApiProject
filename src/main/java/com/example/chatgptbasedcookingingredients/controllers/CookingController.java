package com.example.chatgptbasedcookingingredients.controllers;

import com.example.chatgptbasedcookingingredients.Service.ChatGptCookingService;
import com.example.chatgptbasedcookingingredients.Service.ChatGptService;
import com.example.chatgptbasedcookingingredients.models.CookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cooking")
@RequiredArgsConstructor
public class CookingController {
    private final ChatGptCookingService cookingService;
    @PostMapping
    String createCookingInstruction(@RequestBody CookingRequest request) {
        return cookingService.getRecipe(request);
    }

}

