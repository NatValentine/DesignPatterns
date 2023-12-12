package com.designPatterns.creationalPatterns.prototype;

public interface Component {
    void render();

    Component clone();
}
