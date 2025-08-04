package com.samichinam.docucheck.service;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CrossReferenceServiceTest {

    private final CrossReferenceService service = new CrossReferenceService();

    @Test
    void identifiesOutdatedReferences() {
        Map<String, String> references = Map.of(
            "SOP-001", "1",
            "BR-100", "A"
        );
        Map<String, String> latest = Map.of(
            "SOP-001", "2",
            "BR-100", "A"
        );
        List<String> outdated = service.findOutdatedReferences(references, latest);
        assertEquals(List.of("SOP-001"), outdated);
    }

    @Test
    void returnsEmptyWhenNoOutdated() {
        Map<String, String> references = Map.of("SOP-001", "2");
        Map<String, String> latest = Map.of("SOP-001", "2");
        List<String> outdated = service.findOutdatedReferences(references, latest);
        assertTrue(outdated.isEmpty());
    }
}
