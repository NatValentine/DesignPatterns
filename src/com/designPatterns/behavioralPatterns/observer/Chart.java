package com.designPatterns.behavioralPatterns.observer;

public class Chart implements Observer {
    @Override
    public void update() {
        System.out.println("Chart notified");
    }
}
