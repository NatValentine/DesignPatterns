package com.designPatterns.structuralPatterns.proxy;

public class EbookProxy implements Ebook {
    private  String fileName;
    private RealEbook ebook = null;

    public EbookProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void show() {
        if (this.ebook == null)
            this.ebook = new RealEbook(fileName);

        this.ebook.show();
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }
}
