package com.github.koryu25.inchakun.command;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {

    @Getter
    private final String command;

    @Getter
    private final List<String> args;

    public Command(String text) {
        List<String> contents = new ArrayList<>(Arrays.asList(text.split(" ")));
        this.command = contents.get(0);
        contents.remove(0);
        this.args = contents;
    }
}
