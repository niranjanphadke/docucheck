package com.samichinam.docucheck.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Checks that batch records and SOP references in an investigation are
 * up to date. The implementation is intentionally simple and compares
 * the referenced revision of a document against a provided map of the
 * latest revisions. Any mismatches are returned for further handling.
 */
public class CrossReferenceService {

    /**
     * Determine which referenced documents are outdated.
     *
     * @param references mapping of document identifier to referenced revision
     * @param latest mapping of document identifier to latest revision
     * @return list of document identifiers that are outdated
     */
    public List<String> findOutdatedReferences(Map<String, String> references,
                                               Map<String, String> latest) {
        List<String> outdated = new ArrayList<>();
        for (Map.Entry<String, String> ref : references.entrySet()) {
            String current = latest.get(ref.getKey());
            if (current != null && !current.equals(ref.getValue())) {
                outdated.add(ref.getKey());
            }
        }
        return outdated;
    }
}
