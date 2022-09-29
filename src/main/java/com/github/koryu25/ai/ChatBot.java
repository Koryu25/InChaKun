package com.github.koryu25.ai;

import com.github.koryu25.ai.json.Chat;
import com.github.koryu25.ai.json.JsonParser;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ChatBot {

    //public static List<Member> inChatMembers = new ArrayList<>();

    public static void chat(Message message, String text) {
        try {
            String response = new RequestManager()
                    .addParameter("text=" + text)
                    .send();

            JsonParser jsonParser = new JsonParser();
            Chat chat = jsonParser.parse(response);
            message.reply(chat.getText()).queue();
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
