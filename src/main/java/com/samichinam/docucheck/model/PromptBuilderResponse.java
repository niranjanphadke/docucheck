package com.samichinam.docucheck.model;

public class PromptBuilderResponse {
    private String prompt;

    public PromptBuilderResponse() {
    }

    public PromptBuilderResponse(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
