package com.samichinam.docucheck.model;

public class Capa {
    private String id;
    private String reportId;
    private boolean effective;

    public Capa() {
    }

    public Capa(String id, String reportId, boolean effective) {
        this.id = id;
        this.reportId = reportId;
        this.effective = effective;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public boolean isEffective() {
        return effective;
    }

    public void setEffective(boolean effective) {
        this.effective = effective;
    }
}
