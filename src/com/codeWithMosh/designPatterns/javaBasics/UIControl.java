package com.codeWithMosh.designPatterns.javaBasics;

public abstract  class UIControl {
    public void enable() {
        System.out.println("Enabled");
    }

    public abstract void draw();
}
