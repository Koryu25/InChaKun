package com.github.koryu25.discord;

import com.github.koryu25.inchakun.InChaKun;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;

public class Bot {

    private final String TOKEN = "ODkzNzE2MzM1NzQ4NjEyMTA3.GNUdsP.518_O2XjUzRvIhuXs8OS_gPlwtx4oKp9OtM9lo";

    @Getter
    private JDA jda;
    @Getter
    private Guild inChaGuru;

    public void run() {
        jda = JDABuilder.createDefault(TOKEN)
                .setActivity(Activity.playing("陰キャグル"))
                .build();

        try {
            jda.awaitReady();

            inChaGuru = jda.getGuildById("837323905840185405");
            if (inChaGuru == null)
                System.out.println("陰キャグルインスタンスがnullです");
            else
                System.out.println("陰キャグルの取得に成功しました");

            InChaKun.instance.awaitInput();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        jda.shutdown();
    }
}
