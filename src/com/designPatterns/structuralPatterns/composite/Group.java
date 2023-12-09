package com.designPatterns.structuralPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Group implements  Component{
    private List<Component> components = new ArrayList<>();

    public void add(Component cmp) {
        this.components.add(cmp);
    }

    @Override
    public void render() {
        for (Component cmp : this.components)
            cmp.render();
    }

    @Override
    public void move() {
        for (Component cmp : this.components)
            cmp.move();
    }
}
