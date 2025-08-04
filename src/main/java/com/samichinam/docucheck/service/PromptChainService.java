package com.samichinam.docucheck.service;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Executes a sequence of prompts, feeding the output of each prompt into the next one.
 */
@Service
public class PromptChainService {

    private final ChatModel model;

    public PromptChainService() {
        this.model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .build();
    }

    public List<String> executeChain(List<String> prompts) {
        List<String> responses = new ArrayList<>();
        String context = null;
        for (String prompt : prompts) {
            String input = context == null ? prompt : context + "\n" + prompt;
            context = model.chat(input);
            responses.add(context);
        }
        return responses;
    }
}
