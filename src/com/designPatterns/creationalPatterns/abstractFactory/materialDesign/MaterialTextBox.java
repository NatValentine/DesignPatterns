package com.designPatterns.creationalPatterns.abstractFactory.materialDesign;

import com.designPatterns.creationalPatterns.abstractFactory.TextBox;

public class MaterialTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Render Material text box");
    }
}
