package com.samichinam.docucheck.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DocumentParserServiceTest {

    private final DocumentParserService parser = new DocumentParserService();

    @Test
    void parsesDocx() throws Exception {
        Path path = Files.createTempFile("doc", ".docx");
        try (XWPFDocument doc = new XWPFDocument()) {
            doc.createParagraph().createRun().setText("Hello DOCX");
            doc.write(Files.newOutputStream(path));
        }
        String text = parser.parse(path);
        assertTrue(text.contains("Hello DOCX"));
    }

    @Test
    void parsesPdf() throws Exception {
        Path path = Files.createTempFile("pdf", ".pdf");
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);
            try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(100, 700);
                cs.showText("Hello PDF");
                cs.endText();
            }
            doc.save(path.toFile());
        }
        String text = parser.parse(path);
        assertTrue(text.contains("Hello PDF"));
    }
}
