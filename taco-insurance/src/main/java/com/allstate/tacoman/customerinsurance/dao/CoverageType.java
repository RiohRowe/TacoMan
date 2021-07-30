package com.allstate.tacoman.customerinsurance.dao;

public enum CoverageType {
    AUTO(.83),
    HOME(1.02),
    LIFE(1.36);

    private final Double multiplier;

    CoverageType(Double multiplier) {
        this.multiplier = multiplier;
    }

    public Double getMultiplier() {
        return multiplier;
    }
}
