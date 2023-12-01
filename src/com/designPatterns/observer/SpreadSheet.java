package com.designPatterns.observer;

public class SpreadSheet implements Observer {
    @Override
    public void update() {
        System.out.println("SpreadSheet notified");
    }
}
