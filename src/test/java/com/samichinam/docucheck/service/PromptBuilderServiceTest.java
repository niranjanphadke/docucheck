package com.samichinam.docucheck.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PromptBuilderServiceTest {

    private final PromptBuilderService service = new PromptBuilderService();

    @Test
    void buildsPrompt() {
        String prompt = service.buildPrompt("Review report", List.of("Section A", "Section B"));
        assertTrue(prompt.contains("Review report"));
        assertTrue(prompt.contains("1. Section A"));
        assertTrue(prompt.contains("2. Section B"));
    }
}
