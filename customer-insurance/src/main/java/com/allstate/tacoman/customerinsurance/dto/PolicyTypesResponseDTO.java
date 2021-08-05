package com.allstate.tacoman.customerinsurance.dto;

import com.allstate.tacoman.customerinsurance.dao.CoverageType;
import com.allstate.tacoman.customerinsurance.dao.DeductibleType;
import com.allstate.tacoman.customerinsurance.dao.PolicyType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PolicyTypesResponseDTO {
    private List<String> policyTypes;
    private List<String> coverageTypes;
    private List<String> deductibleTypes;

    public PolicyTypesResponseDTO() {
        this.policyTypes = Arrays.asList(PolicyType.values())
                .stream().map((PolicyType type) -> {
                    return type.toString().toLowerCase();
                }).collect(Collectors.toList());
        this.coverageTypes = Arrays.asList(CoverageType.values())
                .stream().map((CoverageType type) -> {
                    return type.toString().toLowerCase();
                }).collect(Collectors.toList());
        this.deductibleTypes = Arrays.asList(DeductibleType.values())
                .stream().map((DeductibleType type) -> {
                    return type.toString().toLowerCase();
                }).collect(Collectors.toList());
    }

    public List<String> getPolicyTypes() {
        return policyTypes;
    }

    public List<String> getCoverageTypes() {
        return coverageTypes;
    }

    public List<String> getDeductibleTypes() {
        return deductibleTypes;
    }
}
