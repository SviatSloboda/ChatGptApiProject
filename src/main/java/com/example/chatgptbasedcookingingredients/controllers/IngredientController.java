package com.example.chatgptbasedcookingingredients.controllers;


import com.example.chatgptbasedcookingingredients.Service.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final ChatGptService chatGptService;
    @PostMapping
    String categorizeIngredient(@RequestBody String ingredient) {
        System.out.println(ingredient);
        return chatGptService.chatGpt("Answer in one word. Is " + ingredient + " vegan, vegetarian or regular?");

        //return chatGptService.chatGpt(ingredient);
    }

}
