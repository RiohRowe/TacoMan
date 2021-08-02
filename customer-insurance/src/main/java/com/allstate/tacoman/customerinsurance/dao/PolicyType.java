package com.allstate.tacoman.customerinsurance.dao;

public enum PolicyType {
    AUTO (110.00),
    HOME (80.00),
    LIFE (20.00);

    private final Double baseRate;

    PolicyType(Double baseRate) {
        this.baseRate = baseRate;
    }

    public Double getBaseRate() {
        return baseRate;
    }

}
