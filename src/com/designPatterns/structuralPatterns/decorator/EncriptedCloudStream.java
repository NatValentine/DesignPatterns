package com.designPatterns.structuralPatterns.decorator;

public class EncriptedCloudStream implements Stream {
    private Stream stream;

    public EncriptedCloudStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        String encryptedData = encrypt(data);
        this.stream.write(encryptedData);
    }

    private String encrypt(String data) {
        return "!@#$(!@#$(!@#$(!@#";
    }
}
