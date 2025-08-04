package com.samichinam.docucheck.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DataIntegrityServiceTest {

    private final DataIntegrityService service = new DataIntegrityService();

    @Test
    void passesCompleteRecord() {
        String record = "Author: Jane\nTimestamp: 2024-01-01\nOriginal document\nAccurate";
        List<String> missing = service.checkAlcoaPlus(record);
        assertTrue(missing.isEmpty());
    }

    @Test
    void flagsMissingPrinciples() {
        List<String> missing = service.checkAlcoaPlus("partial record");
        assertTrue(missing.contains("attributable"));
        assertTrue(missing.contains("contemporaneous"));
        assertTrue(missing.contains("original"));
        assertTrue(missing.contains("accurate"));
    }
}
