package com.designPatterns.creationalPatterns.abstractFactory.materialDesign;

import com.designPatterns.creationalPatterns.abstractFactory.Button;

public class MaterialButton implements Button {
    @Override
    public void render() {
        System.out.println("Render Material button");
    }
}
