package com.example.chatgptbasedcookingingredients.Service;

import com.example.chatgptbasedcookingingredients.models.CookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatGptCookingService {
    private final ChatGptService service;
    public String getRecipe(CookingRequest request){
        return service.chatGpt("I have these ingredients " + request.ingredients().toString() + ". Create a cooking instruction for a dish with them. Result should be in a json format containing a title, description, and list of ingredients.");
    }
}
