package com.codeWithMosh.designPatterns.iterator;

public interface Iterator<T> {
    boolean hasNext();
    T current();
    void next();
}
