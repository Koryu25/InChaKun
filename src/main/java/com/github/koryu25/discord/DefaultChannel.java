package com.github.koryu25.discord;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

@AllArgsConstructor
public enum DefaultChannel {
    HITORIGOTO("独り言", 923174877534486528L),
    ZATUDAN_ONE("雑談1", 837341373547544596L),
    ZATUDAN_TWO("雑談2", 837341635146022932L),
    ZATUDAN_THREE("雑談3", 837341665114980443L),
    KIKISEN_ONE("大聞き専1", 845980155360837632L),
    KIKISEN_TWO("大聞き専2", 849254065170284554L);

    @Getter
    private String jp;
    @Getter
    private long id;

    public static DefaultChannel fromJp(String jp) {
        for (DefaultChannel channel : DefaultChannel.values()) {
            if (channel.jp.equals(jp))
                return channel;
        }
        return null;
    }
}
