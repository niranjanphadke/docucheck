package com.samichinam.docucheck.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Simple parser that extracts text from DOCX and PDF documents.
 */
@Service
public class DocumentParserService {

    /**
     * Parse a document to plain text based on its file extension.
     * Supports .docx and .pdf files; all other files are treated as UTF-8 text.
     */
    public String parse(Path path) throws IOException {
        String fileName = path.getFileName().toString().toLowerCase();
        if (fileName.endsWith(".docx")) {
            return parseDocx(path);
        }
        if (fileName.endsWith(".pdf")) {
            return parsePdf(path);
        }
        return Files.readString(path);
    }

    private String parseDocx(Path path) throws IOException {
        try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(path));
             XWPFWordExtractor extractor = new XWPFWordExtractor(doc)) {
            return extractor.getText();
        }
    }

    private String parsePdf(Path path) throws IOException {
        try (PDDocument pdf = PDDocument.load(path.toFile())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(pdf);
        }
    }
}
