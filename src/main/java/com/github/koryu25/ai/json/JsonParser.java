package com.github.koryu25.ai.json;

import com.google.gson.Gson;

public class JsonParser {
    private Gson gson = new Gson();

    public Chat parse(String json) {
        Chat chat = gson.fromJson(json, Chat.class);
        return chat;
    }
}
