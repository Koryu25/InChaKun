package com.github.koryu25.inchakun.command;

import com.github.koryu25.inchakun.command.commands.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final List<CommandProcessor> processorList = new ArrayList<>();

    public CommandManager() {
        processorList.add(new SendMessage());
    }

    public CommandProcessor getProcessor(Command command) {
        for (CommandProcessor processor : processorList) {
            if (processor.match(command.getCommand()))
                return processor;
        }
        return null;
    }
}
