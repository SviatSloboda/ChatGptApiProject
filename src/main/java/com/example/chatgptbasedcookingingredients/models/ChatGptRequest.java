package com.example.chatgptbasedcookingingredients.models;

import java.util.Collections;
import java.util.List;

public record ChatGptRequest(
        List<ChatGptMessage> messages,
        String model
) {
}
