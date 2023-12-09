package com.designPatterns.behavioralPatterns.iterator;

public interface Iterator<T> {
    boolean hasNext();
    T current();
    void next();
}
