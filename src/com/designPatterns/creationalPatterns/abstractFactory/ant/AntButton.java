package com.designPatterns.creationalPatterns.abstractFactory.ant;

import com.designPatterns.creationalPatterns.abstractFactory.Button;

public class AntButton implements Button {
    @Override
    public void render() {
        System.out.println("Render Ant button");
    }
}
