package com.samichinam.docucheck.controller;

import com.samichinam.docucheck.model.*;
import com.samichinam.docucheck.service.GuidelineService;
import com.samichinam.docucheck.service.PromptChainService;
import com.samichinam.docucheck.service.ValidationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ValidationController {
    private final ValidationService service;
    private final GuidelineService guidelineService;
    private final PromptChainService promptChainService;

    public ValidationController(ValidationService service, GuidelineService guidelineService, PromptChainService promptChainService) {
        this.service = service;
        this.guidelineService = guidelineService;
        this.promptChainService = promptChainService;
    }

    @PostMapping("/validate")
    public ValidationResponse validate(@RequestBody ValidationRequest request) {
        return service.validate(request);
    }

    @PostMapping("/guidelines")
    public void uploadGuidelines(@RequestBody GuidelineRequest request) {
        guidelineService.replaceGuidelines(request.getGuidelines());
    }

    @PostMapping("/prompts/chain")
    public PromptChainResponse runChain(@RequestBody PromptChainRequest request) {
        return new PromptChainResponse(promptChainService.executeChain(request.getPrompts()));
    }
}
