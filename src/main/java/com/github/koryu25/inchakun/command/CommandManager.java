package com.github.koryu25.inchakun.command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final List<CommandProcessor> processorList = new ArrayList<>();

    public CommandManager() {

    }

    public CommandProcessor getProcessor(Command command) {
        for (CommandProcessor processor : processorList) {
            if (processor.match(command.getCommand()))
                return processor;
        }
        return null;
    }
}
