package com.designPatterns.structuralPatterns.decorator;

public class CompressedCloudStream implements Stream {
    private Stream stream;

    public CompressedCloudStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        String compressedData = compress(data);
        this.stream.write(data);
    }

    private String compress(String data) {
        return data.substring(0, 5);
    }
}
