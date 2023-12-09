package com.designPatterns.behavioralPatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> states = new ArrayList<>();

    public void push(EditorState state) {
        this.states.add(state);
    }

    public EditorState pop() {
        states.remove(states.getLast());
        return states.getLast();
    }
}
