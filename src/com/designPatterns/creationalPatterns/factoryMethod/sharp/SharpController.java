package com.designPatterns.creationalPatterns.factoryMethod.sharp;

import com.designPatterns.creationalPatterns.factoryMethod.Controller;
import com.designPatterns.creationalPatterns.factoryMethod.ViewEngine;

import java.util.Map;

public class SharpController implements Controller {
    @Override
    public void render(String viewName, Map<String, Object> data, ViewEngine engine) {
        var html = engine.render(viewName, data);
        System.out.println(html);
    }

    protected ViewEngine createViewEngine() {
        return new SharpViewEngine();
    }
}
