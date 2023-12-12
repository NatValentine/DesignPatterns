package com.designPatterns.creationalPatterns.abstractFactory.materialDesign;

import com.designPatterns.creationalPatterns.abstractFactory.Button;
import com.designPatterns.creationalPatterns.abstractFactory.TextBox;
import com.designPatterns.creationalPatterns.abstractFactory.WidgetFactory;

public class MaterialWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new MaterialButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MaterialTextBox();
    }
}
