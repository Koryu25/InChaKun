package com.github.koryu25.inchakun.command.commands;

import com.github.koryu25.discord.DefaultChannel;
import com.github.koryu25.inchakun.InChaKun;
import com.github.koryu25.inchakun.command.Command;
import com.github.koryu25.inchakun.command.CommandProcessor;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import org.w3c.dom.Text;

/**
 * チャンネルにメッセージを送信します
 * send 雑談1 msg
 */
public class SendMessage implements CommandProcessor {


    @Override
    public String command() {
        return "send";
    }

    @Override
    public void run(Command command) {
        // 引数の数を確認
        if (command.getArgs().size() != 2) {
            System.out.println("引数が間違っています");
            return;
        }
        // チャンネル取得、確認
        DefaultChannel channel = DefaultChannel.fromJp(command.getArgs().get(0));
        if (channel == null) {
            System.out.println("チャンネル名が間違っています");
        }
        TextChannel textChannel = InChaKun.instance.getBot().getJda().getTextChannelById(channel.getId());

        // メッセージ形成
        String message = "";
        for (int i = 1; i > command.getArgs().size(); i++) {
            message = message + command.getArgs().get(i);
        }

        // メッセージ送信
        textChannel.sendMessage(MessageCreateData.fromContent(message));
    }
}
