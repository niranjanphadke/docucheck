package com.samichinam.docucheck.model;

import java.util.List;

/**
 * Payload for uploading guideline text to the vector store.
 */
public class GuidelineRequest {
    private List<String> guidelines;

    public GuidelineRequest() {}

    public GuidelineRequest(List<String> guidelines) {
        this.guidelines = guidelines;
    }

    public List<String> getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(List<String> guidelines) {
        this.guidelines = guidelines;
    }
}
