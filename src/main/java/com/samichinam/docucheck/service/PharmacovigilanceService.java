package com.samichinam.docucheck.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Performs extremely naive pharmacovigilance checks by scanning text for
 * potential adverse event or product complaint statements. This is merely a
 * demonstrative placeholder for the feature outlined in {@code features.md}.
 */
public class PharmacovigilanceService {

    /**
     * Extract sentences that may describe an adverse event.
     *
     * @param text free-form report text
     * @return list of sentences containing keywords associated with adverse events
     */
    public List<String> findPotentialAdverseEvents(String text) {
        List<String> events = new ArrayList<>();
        if (text == null || text.isBlank()) {
            return events;
        }
        String[] sentences = text.split("(?<=\\.)\\s+");
        for (String sentence : sentences) {
            String lower = sentence.toLowerCase();
            if (lower.contains("adverse") || lower.contains("complaint") ||
                lower.contains("side effect")) {
                events.add(sentence.trim());
            }
        }
        return events;
    }
}
