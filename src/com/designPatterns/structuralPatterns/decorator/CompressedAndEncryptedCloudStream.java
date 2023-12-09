package com.designPatterns.structuralPatterns.decorator;

public class CompressedAndEncryptedCloudStream extends CloudStream {
    @Override
    public void write(String data) {
        String encryptedData = encrypt(data);
        String compressedData = compress(encryptedData);
        super.write(compressedData);
    }

    private String encrypt(String data) {
        return "!@#$(!@#$(!@#$(!@#";
    }

    private String compress(String data) {
        return data.substring(0, 5);
    }
}

// Implementation which sucks. Favor composition over inheritance.
