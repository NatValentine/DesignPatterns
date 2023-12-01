package com.designPatterns.strategy;

public class ImageStorage {
    public void store(String fileName, Compressor compressor, Filter filter) {
        compressor.compress(fileName);
        filter.apply(fileName);

        /*  as opposed to:
        if (compressor == "jpeg")
            System.out.println("Compressing using JPEG");
        else if (compressor == "png")
            System.out.println("Compressing using PNG");

        if (filter == "b&w")
            System.out.println("Applying b&w filter");
        else if (filter == "high-contrast")
            System.out.println("Applying high-contrast filter");
         */
    }
}
