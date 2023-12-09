package com.designPatterns.structuralPatterns.adapter;

import com.designPatterns.structuralPatterns.adapter.externalFilters.Caramel;

// Alternative implementation using inheritance. Since Java doesn't have multiple inheritance, this implementation is not as flexible.
public class CaramelAdapter extends Caramel implements Filter {
    @Override
    public void apply(Image img) {
        init();
        render(img);
    }
}
