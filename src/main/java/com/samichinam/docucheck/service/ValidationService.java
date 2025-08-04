package com.samichinam.docucheck.service;

import com.samichinam.docucheck.model.ValidationRequest;
import com.samichinam.docucheck.model.ValidationResponse;
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
