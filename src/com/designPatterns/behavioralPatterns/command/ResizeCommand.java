package com.designPatterns.behavioralPatterns.command;

import com.designPatterns.behavioralPatterns.command.fx.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Resize");
    }
}
