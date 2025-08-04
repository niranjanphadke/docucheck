package com.samichinam.docucheck.model;

import java.util.List;

/**
 * Response object for prompt chain execution.
 */
public class PromptChainResponse {
    private List<String> responses;

    public PromptChainResponse() {}

    public PromptChainResponse(List<String> responses) {
        this.responses = responses;
    }

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }
}
