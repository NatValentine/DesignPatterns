package com.designPatterns.strategy;

public class HCFilter implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("Applying high-contrast filter...");
    }
}
