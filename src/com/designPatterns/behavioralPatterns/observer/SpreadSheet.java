package com.designPatterns.behavioralPatterns.observer;

public class SpreadSheet implements Observer {
    @Override
    public void update() {
        System.out.println("SpreadSheet notified");
    }
}
