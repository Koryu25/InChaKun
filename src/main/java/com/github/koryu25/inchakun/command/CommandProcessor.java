package com.github.koryu25.inchakun.command;

public interface CommandProcessor {

    String command();

    void run(Command command);

    default boolean match(String text) {
        return command().equals(text);
    }
}
