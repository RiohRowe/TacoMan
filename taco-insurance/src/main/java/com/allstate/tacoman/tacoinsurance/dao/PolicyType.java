package com.allstate.tacoman.tacoinsurance.dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class PolicyType {
    @Id
    @GeneratedValue
    private Long id;
    private Double rate;
    private Boolean theft;
    private Boolean dropped;
    private Boolean rot;
    private Boolean waterDamage;
    private Boolean fireDamage;
    private Boolean consumerMedical;
//    @OneToMany(cascade = CascadeType.REMOVE)
//    private List<TacoInsurancePolicy> policies;
}
