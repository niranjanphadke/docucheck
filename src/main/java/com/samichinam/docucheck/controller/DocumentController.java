package com.samichinam.docucheck.controller;

import com.samichinam.docucheck.service.DocumentParserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

/**
 * Exposes document parsing for DOCX/PDF files.
 */
@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentParserService parserService;

    public DocumentController(DocumentParserService parserService) {
        this.parserService = parserService;
    }

    @PostMapping("/parse")
    public String parse(@RequestBody Map<String, String> request) throws IOException {
        Path path = Path.of(request.get("path"));
        return parserService.parse(path);
    }
}
