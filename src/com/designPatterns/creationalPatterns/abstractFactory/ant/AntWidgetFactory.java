package com.designPatterns.creationalPatterns.abstractFactory.ant;

import com.designPatterns.creationalPatterns.abstractFactory.Button;
import com.designPatterns.creationalPatterns.abstractFactory.TextBox;
import com.designPatterns.creationalPatterns.abstractFactory.WidgetFactory;

public class AntWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new AntButton();
    }

    @Override
    public TextBox createTextBox() {
        return new AntTextBox();
    }
}
