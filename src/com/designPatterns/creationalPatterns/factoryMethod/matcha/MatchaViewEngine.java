package com.designPatterns.creationalPatterns.factoryMethod.matcha;

import com.designPatterns.creationalPatterns.factoryMethod.ViewEngine;

import java.util.Map;

public class MatchaViewEngine implements ViewEngine {
    @Override
    public String render(String viewName, Map<String, Object> data) {
        return "View rendered by Matcha";
    }
}
