package com.designPatterns.creationalPatterns.prototype;

public class Circle implements Component {
    private int radius;
    @Override
    public void render() {
        System.out.println("Rendering a circle.");
    }

    @Override
    public Component clone() {
        Circle newCircle = new Circle();
        newCircle.setRadius(this.getRadius());
        return newCircle;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
