package com.example.chatgptbasedcookingingredients.models;

import java.util.List;

public record ChatGptResponse(
        List<ChatGptChoice> choices
) {
}
