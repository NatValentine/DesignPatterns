package com.designPatterns.behavioralPatterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {
    private List<HtmlNode> nodes = new ArrayList<>();

    public void add(HtmlNode node) {
        this.nodes.add(node);
    }
    public void execute(Operation operation) {
        for (HtmlNode node : this.nodes)
            node.execute(operation);
    }
}
