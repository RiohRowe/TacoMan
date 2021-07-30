package com.allstate.tacoman.customerinsurance.dto;

import com.allstate.tacoman.customerinsurance.dao.Policy;

public class PolicyQuoteResponseDTO {
    private Double premium;
    private Double deductible;
    private String policyType;
    private String coverageType;

    public PolicyQuoteResponseDTO(Policy policy) {
        this.premium = policy.getPremium();
        this.deductible = policy.getDeductible();
        this.policyType = policy.getPolicyType().toString();
        this.coverageType = policy.getCoverageType().toString();
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
