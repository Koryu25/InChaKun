package com.github.koryu25.inchakun;

import com.github.koryu25.discord.Bot;
import com.github.koryu25.inchakun.command.Command;
import com.github.koryu25.inchakun.command.CommandManager;
import com.github.koryu25.inchakun.command.CommandProcessor;
import lombok.Getter;

import java.util.Scanner;

public class InChaKun {

    public static InChaKun instance;

    @Getter
    private final Bot bot = new Bot();

    private final CommandManager commandManager = new CommandManager();

    public InChaKun() {
        instance = this;

        System.out.println("Starting InChaKun...");

        bot.run();
    }

    public void awaitInput() {
        System.out.println("コマンドを入力してください:");
        String input = new Scanner(System.in).next();

        if (input.equalsIgnoreCase("stop")) {
            bot.stop();
        } else {
            // コマンドの形成
            Command command = new Command(input);

            // コマンドプロセッサ取得
            CommandProcessor processor = commandManager.getProcessor(command);

            // nullのときログ出力
            if (processor == null)
                System.out.println("無効なコマンドが入力されました。");
            // 存在したらコマンド実行
            else
                processor.run(command);

            // 次の入力を待つ
            awaitInput();
        }
    }
}
