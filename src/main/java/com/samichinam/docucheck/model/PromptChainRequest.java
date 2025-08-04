package com.samichinam.docucheck.model;

import java.util.List;

/**
 * Request payload containing a sequence of prompts to execute sequentially.
 */
public class PromptChainRequest {
    private List<String> prompts;

    public PromptChainRequest() {}

    public PromptChainRequest(List<String> prompts) {
        this.prompts = prompts;
    }

    public List<String> getPrompts() {
        return prompts;
    }

    public void setPrompts(List<String> prompts) {
        this.prompts = prompts;
    }
}
