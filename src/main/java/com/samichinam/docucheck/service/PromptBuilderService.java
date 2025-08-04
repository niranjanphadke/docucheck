package com.samichinam.docucheck.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Builds guided prompts for users based on desired sections.
 */
@Service
public class PromptBuilderService {

    public String buildPrompt(String objective, List<String> sections) {
        StringBuilder sb = new StringBuilder();
        sb.append("Objective: ").append(objective).append("\n\n");
        for (int i = 0; i < sections.size(); i++) {
            sb.append(i + 1).append(". ").append(sections.get(i)).append("\n");
        }
        return sb.toString();
    }
}
