package com.samichinam.docucheck.model;

public class ValidationRequest {
    private String systemPrompt;
    private String guideLineText;
    private String documentText;

    public String getSystemPrompt() {
        return systemPrompt;
    }

    public void setSystemPrompt(String systemPrompt) {
        this.systemPrompt = systemPrompt;
    }

    public String getGuideLineText() {
        return guideLineText;
    }

    public void setGuideLineText(String guideLineText) {
        this.guideLineText = guideLineText;
    }

    public String getDocumentText() {
        return documentText;
    }

    public void setDocumentText(String documentText) {
        this.documentText = documentText;
    }
}
