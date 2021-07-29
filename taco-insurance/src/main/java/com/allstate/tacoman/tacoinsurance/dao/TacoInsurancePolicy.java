package com.allstate.tacoman.tacoinsurance.dao;

import javax.persistence.*;

@Entity
public class TacoInsurancePolicy {
    @Id
    @GeneratedValue
    private Long id;
    private Double tacoValue;
    private Double premium;
    private Double deductible;
    @OneToOne
    private Taco taco;
    @ManyToOne
    private PolicyType policyType;
}
