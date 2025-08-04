package com.samichinam.docucheck.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Very small document parser used solely for demonstration and testing
 * purposes. It reads the contents of a file as UTF-8 text regardless of
 * the file extension.
 */
public class DocumentParserService {

    /**
     * Parse a document to plain text.
     *
     * @param path path to the document
     * @return contents of the file as a string
     */
    public String parse(Path path) throws IOException {
        return Files.readString(path);
    }
}
