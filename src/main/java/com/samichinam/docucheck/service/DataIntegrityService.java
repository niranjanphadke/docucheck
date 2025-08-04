package com.samichinam.docucheck.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Performs very lightweight ALCOA+ data integrity checks. The goal is not to
 * provide a production ready implementation but to demonstrate how the feature
 * described in {@code features.md} could be modelled in code.
 */
public class DataIntegrityService {

    /**
     * Validate a textual record against basic ALCOA+ principles and return any
     * missing elements. Checks are intentionally simplistic: a record is
     * considered compliant with a principle if a keyword is present.
     *
     * @param record text representing the record to check
     * @return list of missing ALCOA+ principles
     */
    public List<String> checkAlcoaPlus(String record) {
        List<String> missing = new ArrayList<>();
        if (record == null || record.isBlank()) {
            missing.add("legible");
            missing.add("original");
            missing.add("accurate");
            missing.add("attributable");
            missing.add("contemporaneous");
            return missing;
        }
        String lower = record.toLowerCase();
        if (!lower.contains("author")) {
            missing.add("attributable");
        }
        if (!lower.contains("timestamp")) {
            missing.add("contemporaneous");
        }
        if (!lower.contains("original")) {
            missing.add("original");
        }
        if (!(lower.contains("accurate") || lower.contains("verified"))) {
            missing.add("accurate");
        }
        // "legible" is assumed satisfied if record is not blank
        return missing;
    }
}
