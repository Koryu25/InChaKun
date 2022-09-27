package com.github.koryu25.discord;

import com.github.koryu25.InChaKun;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;

public class Bot {

    private final String TOKEN = "ODkzNzE2MzM1NzQ4NjEyMTA3.GNUdsP.518_O2XjUzRvIhuXs8OS_gPlwtx4oKp9OtM9lo";

    private JDA jda;
    private Guild inChaGuru;

    public void run(InChaKun inChaKun) {
        jda = JDABuilder.createDefault(TOKEN)
                .setActivity(Activity.playing("陰キャグル"))
                .build();

        inChaGuru = jda.getGuildById(837323905840185405L);

        try {
            jda.awaitReady();
            inChaKun.awaitInput();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        jda.shutdown();
    }
}
