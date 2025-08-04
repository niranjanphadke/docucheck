package com.samichinam.docucheck.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PharmacovigilanceServiceTest {

    private final PharmacovigilanceService service = new PharmacovigilanceService();

    @Test
    void extractsAdverseEventSentences() {
        String text = "Patient reported nausea. Later an adverse event occurred. No further complaint.";
        List<String> events = service.findPotentialAdverseEvents(text);
        assertEquals(List.of("Later an adverse event occurred.", "No further complaint."), events);
    }

    @Test
    void returnsEmptyWhenNoKeywords() {
        String text = "Batch executed successfully without incidents.";
        List<String> events = service.findPotentialAdverseEvents(text);
        assertTrue(events.isEmpty());
    }
}
