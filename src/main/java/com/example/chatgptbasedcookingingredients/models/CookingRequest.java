package com.example.chatgptbasedcookingingredients.models;

import java.util.List;

public record CookingRequest(
        List<String> ingredients
) {
}
