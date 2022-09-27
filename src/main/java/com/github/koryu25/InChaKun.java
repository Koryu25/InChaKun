package com.github.koryu25;

import com.github.koryu25.discord.Bot;
import lombok.Getter;

import java.util.Scanner;

public class InChaKun {

    @Getter
    private Bot bot;

    private final Scanner scanner = new Scanner(System.in);

    public InChaKun() {
        System.out.println("Starting InChaKun...");

        bot = new Bot();
        bot.run(this);
    }

    public void awaitInput() {
        System.out.println("コマンドを入力してください:");
        String input = scanner.next();

        if (input.equalsIgnoreCase("stop")) {
            bot.stop();
        } else {
            System.out.println("無効なコマンドが入力されました。");
            awaitInput();
        }
    }
}
