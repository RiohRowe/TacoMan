package com.allstate.tacoman.customerinsurance.dto;

import java.io.Serializable;

public class PolicyQuoteResponseDTO {
    private Double premium;
    private Double deductible;
    private String policyType;
    private String coverageType;

    public PolicyQuoteResponseDTO(Double premium, Double deductible, String policyType, String coverageType) {
        this.premium = premium;
        this.deductible = deductible;
        this.policyType = policyType;
        this.coverageType = coverageType;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Double getDeductible() {
        return deductible;
    }

    public void setDeductible(Double deductible) {
        this.deductible = deductible;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }
}
