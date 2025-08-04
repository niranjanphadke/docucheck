package com.samichinam.docucheck.model;

import java.util.List;
import java.util.Map;

public class ValidationResponse {
    private String validationStatus;
    private Map<String, String> complianceBreakdown;
    private List<String> recommendations;

    public ValidationResponse() {
    }

    public ValidationResponse(String validationStatus, Map<String, String> complianceBreakdown, List<String> recommendations) {
        this.validationStatus = validationStatus;
        this.complianceBreakdown = complianceBreakdown;
        this.recommendations = recommendations;
    }

    public String getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(String validationStatus) {
        this.validationStatus = validationStatus;
    }

    public Map<String, String> getComplianceBreakdown() {
        return complianceBreakdown;
    }

    public void setComplianceBreakdown(Map<String, String> complianceBreakdown) {
        this.complianceBreakdown = complianceBreakdown;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }
}
