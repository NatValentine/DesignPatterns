package com.designPatterns.creationalPatterns.factoryMethod;

import com.designPatterns.creationalPatterns.factoryMethod.matcha.MatchaController;
import com.designPatterns.creationalPatterns.factoryMethod.matcha.MatchaViewEngine;
import com.designPatterns.creationalPatterns.factoryMethod.sharp.SharpController;

import java.util.HashMap;
import java.util.Map;

public class ProductsController extends SharpController {
    public void listProducts() {
        // get products from a database
        Map<String, Object> data = new HashMap<>();
        // data.put(products)
        render("products.html", data, this.createViewEngine());
    }
}
