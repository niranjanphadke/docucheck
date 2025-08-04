package com.samichinam.docucheck.controller;

import com.samichinam.docucheck.model.ValidationRequest;
import com.samichinam.docucheck.model.ValidationResponse;
import com.samichinam.docucheck.service.ValidationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ValidationController {
    private final ValidationService service;

    public ValidationController(ValidationService service) {
        this.service = service;
    }

    @PostMapping("/validate")
    public ValidationResponse validate(@RequestBody ValidationRequest request) {
        return service.validate(request);
    }
}
