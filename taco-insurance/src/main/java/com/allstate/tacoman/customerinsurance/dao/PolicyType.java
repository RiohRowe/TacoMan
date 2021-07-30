package com.allstate.tacoman.customerinsurance.dao;

public enum PolicyType {
    DIRT(100.00),
    BASIC(200.00),
    STANDARD(300.00),
    ENHANCED(400.00),
    PREMIUM(500.00);

    private final Double baseRate;

    PolicyType(Double baseRate) {
        this.baseRate = baseRate;
    }

    public Double getBasePremium() {
        return baseRate;
    }

    public Double getBaseDeductible() {
        return 1100 - (2 * baseRate);
    }
}
