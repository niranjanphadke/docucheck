package com.samichinam.docucheck.service;

import java.util.List;

/**
 * Builds guided prompts for users based on desired sections. The original
 * implementation used Spring's {@code @Service} annotation, but removing
 * the dependency keeps the project lightweight and compatible with the
 * limited build environment.
 */
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
