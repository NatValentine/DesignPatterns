package com.designPatterns.behavioralPatterns.visitor;

public class PlainTextOperation implements Operation {

    @Override
    public void apply(HeadingNode heading) {
        System.out.println("Plain text heading");
    }

    @Override
    public void apply(AnchorNode anchor) {
        System.out.println("Plain text anchor");
    }
}
