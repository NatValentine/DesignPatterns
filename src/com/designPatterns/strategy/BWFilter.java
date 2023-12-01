package com.designPatterns.strategy;

public class BWFilter implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("Applying black and white filter...");
    }
}
