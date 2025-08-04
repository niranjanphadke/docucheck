package com.samichinam.docucheck.model;

import java.util.List;

public class PromptBuilderRequest {
    private String objective;
    private List<String> sections;

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<String> getSections() {
        return sections;
    }

    public void setSections(List<String> sections) {
        this.sections = sections;
    }
}
