package com.allstate.tacoman.customerinsurance.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Policy {
    @Id
    @GeneratedValue
    private Long id;
    private String policyNumber;
    private PolicyType policyType;
    private CoverageType coverageType;
    private Date processDate;
    private Date effectiveDate;
    private DeductibleType deductibleType;
    private Double premium;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public PolicyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }

    public CoverageType getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(CoverageType coverageType) {
        this.coverageType = coverageType;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public DeductibleType getDeductible() {
        return deductibleType;
    }

    public void setDeductible(DeductibleType deductibleType) {
        this.deductibleType = deductibleType;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
