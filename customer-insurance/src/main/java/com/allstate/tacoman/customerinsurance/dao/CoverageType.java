package com.allstate.tacoman.customerinsurance.dao;

public enum CoverageType {
    ECONOMY(.6),
    STANDARD(1.0),
    PREMIUM(1.5);

    private final Double multiplier;

    CoverageType(Double multiplier) {
        this.multiplier = multiplier;
    }

    public Double getMultiplier() {
        return multiplier;
    }
}
