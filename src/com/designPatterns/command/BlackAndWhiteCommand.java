package com.designPatterns.command;

import com.designPatterns.command.fx.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Apply black and white filter");
    }
}
