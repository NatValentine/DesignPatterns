package com.designPatterns.creationalPatterns.factoryMethod;

import com.designPatterns.creationalPatterns.factoryMethod.ViewEngine;

import java.util.Map;

public interface Controller {
    void render(String viewName, Map<String, Object> data, ViewEngine engine);

    private ViewEngine createViewEngine() {
        return null;
    }
}
