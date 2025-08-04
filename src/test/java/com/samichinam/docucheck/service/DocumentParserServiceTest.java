package com.samichinam.docucheck.service;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DocumentParserServiceTest {

    private final DocumentParserService parser = new DocumentParserService();

    @Test
    void parsesDocx() throws Exception {
        Path path = Files.createTempFile("doc", ".docx");
        Files.writeString(path, "Hello DOCX");
        String text = parser.parse(path);
        assertTrue(text.contains("Hello DOCX"));
    }

    @Test
    void parsesPdf() throws Exception {
        Path path = Files.createTempFile("pdf", ".pdf");
        Files.writeString(path, "Hello PDF");
        String text = parser.parse(path);
        assertTrue(text.contains("Hello PDF"));
    }
}
