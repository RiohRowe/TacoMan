package com.allstate.tacoman.customerinsurance.dao;

public enum DeductibleType {
    LOW(1.2, 100.00),
    MEDIUM(1.0, 500.00),
    HIGH(0.8, 1000.00);

    private final Double multiplier;
    private final Double deductible;

    DeductibleType(Double multiplier, Double deductible) {
        this.multiplier = multiplier;
        this.deductible = deductible;
    }

    public Double getMultiplier() {
        return multiplier;
    }
    public Double getDeductible() { return deductible; }
}

