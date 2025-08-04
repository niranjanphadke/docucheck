package com.example.docucheck.service;

import com.example.docucheck.model.ValidationRequest;
import com.example.docucheck.model.ValidationResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ValidationService {
    public ValidationResponse validate(ValidationRequest request) {
        Map<String, String> breakdown = new HashMap<>();
        breakdown.put("description", "pending");
        breakdown.put("impactAssessment", "pending");

        return new ValidationResponse(
                "Pending",
                breakdown,
                List.of("LLM integration not yet implemented")
        );
    }
}
