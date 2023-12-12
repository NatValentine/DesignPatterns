package com.designPatterns.creationalPatterns.factoryMethod.sharp;

import com.designPatterns.creationalPatterns.factoryMethod.ViewEngine;

import java.util.Map;

public class SharpViewEngine implements ViewEngine {
    @Override
    public String render(String viewName, Map<String, Object> data) {
        return "View rendered by Sharp";
    }
}
