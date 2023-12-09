package com.designPatterns.behavioralPatterns.strategy;

public class BWFilter implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("Applying black and white filter...");
    }
}
