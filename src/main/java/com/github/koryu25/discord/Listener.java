package com.github.koryu25.discord;

import com.github.koryu25.ai.ChatBot;
import com.github.koryu25.inchakun.InChaKun;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        if (message.getContentRaw().equals("ping")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!")
                    .queue();
        }

        // chat bot
        if (!event.getMember().getId().equals(InChaKun.instance.getBot().getId())) {
            if (event.getChannel().getId().equals("944386244845109258"))
                ChatBot.chat(message, message.getContentDisplay());
        }
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("ping"))
            return;

        long time = System.currentTimeMillis();
        event.reply("Pong!")
                .flatMap(v ->
                        event.getHook().editOriginalFormat("Pong: %d ms", System.currentTimeMillis() - time)
                ).queue();
    }
}
