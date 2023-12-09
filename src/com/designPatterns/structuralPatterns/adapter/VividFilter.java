package com.designPatterns.structuralPatterns.adapter;

public class VividFilter implements Filter {
    @Override
    public void apply(Image img) {
        System.out.println("Applying vivid filter");
    }
}
