package com.codeWithMosh.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {
    private List<String> urls = new ArrayList<>();

    public void push(String url) {
        urls.add(url);
    }

    public String pop() {
       urls.remove(urls.getLast());
       return urls.getLast();
    }

    public Iterator<String> createIterator() {
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator<String> {
        private BrowseHistory history;
        public ListIterator(BrowseHistory history) {
            this.history = history;
        }

        private int index;

        @Override
        public boolean hasNext() {
            return (index < history.urls.size());
        }

        @Override
        public String current() {
            return history.urls.get(index);
        }

        @Override
        public void next() {
            this.index++;
        }
    }
}
