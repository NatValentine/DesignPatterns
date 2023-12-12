package com.designPatterns.creationalPatterns.builder;

public class PdfBuilder implements PresentationBuilder{
    private Pdf doc = new Pdf();

    @Override
    public void addSlide(Slide slide) {
        doc.addPage(slide.getText());
    }

    public Pdf getPdf() {
        return doc;
    }
}
