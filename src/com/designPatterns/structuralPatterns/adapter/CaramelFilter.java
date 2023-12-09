package com.designPatterns.structuralPatterns.adapter;

import com.designPatterns.structuralPatterns.adapter.externalFilters.Caramel;

public class CaramelFilter implements Filter {
    private Caramel caramel;

    public CaramelFilter(Caramel caramel) {
        this.caramel = caramel;
    }

    @Override
    public void apply(Image img) {
        caramel.init();
        caramel.render(img);
    }
}
