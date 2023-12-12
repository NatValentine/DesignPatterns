package com.designPatterns.creationalPatterns.abstractFactory.app;

import com.designPatterns.creationalPatterns.abstractFactory.WidgetFactory;

public class ContactForm {
    public void render(WidgetFactory factory) {
        factory.createTextBox().render();
        factory.createButton().render();
    }
}
