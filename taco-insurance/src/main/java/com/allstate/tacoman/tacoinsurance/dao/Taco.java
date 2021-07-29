package com.allstate.tacoman.tacoinsurance.dao;

import javax.persistence.*;

@Entity
public class Taco {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double shellCost;
    private Double lettusCost;
    private Double meatCost;
    private Double cheeseCost;
    private Double sauceCost;
//    @OneToOne(cascade= CascadeType.REMOVE)
//    private TacoInsurancePolicy tacoInsurancePolicy;
}
