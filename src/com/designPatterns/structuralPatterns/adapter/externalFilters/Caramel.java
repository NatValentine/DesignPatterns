package com.designPatterns.structuralPatterns.adapter.externalFilters;

import com.designPatterns.structuralPatterns.adapter.Image;

public class Caramel {
    public void init() {

    }
    public void render(Image image) {
        System.out.println("Applying caramel filter");
    }
}
