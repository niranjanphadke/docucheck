package com.samichinam.docucheck.model;

import java.util.List;
import java.util.Map;

public class ValidationResponse {
    private String validationStatus;
    private Map<String, String> complianceBreakdown;
    private List<String> recommendations;
    private Map<String, Double> confidenceScores;

    public ValidationResponse() {
    }

    public ValidationResponse(String validationStatus,
                              Map<String, String> complianceBreakdown,
                              List<String> recommendations,
                              Map<String, Double> confidenceScores) {
        this.validationStatus = validationStatus;
        this.complianceBreakdown = complianceBreakdown;
        this.recommendations = recommendations;
        this.confidenceScores = confidenceScores;
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

    public Map<String, Double> getConfidenceScores() {
        return confidenceScores;
    }

    public void setConfidenceScores(Map<String, Double> confidenceScores) {
        this.confidenceScores = confidenceScores;
    }
}
