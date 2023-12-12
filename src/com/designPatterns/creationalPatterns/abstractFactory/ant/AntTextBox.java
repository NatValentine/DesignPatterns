package com.designPatterns.creationalPatterns.abstractFactory.ant;

import com.designPatterns.creationalPatterns.abstractFactory.TextBox;

public class AntTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Render Ant text box");
    }
}
