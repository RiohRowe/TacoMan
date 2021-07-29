
package com.allstate.tacoman.customerinsurance.dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String zipCode;
    private Integer creditScore;
    private Integer yearsAsCustomer;
    private Long ssn;
    @OneToMany(mappedBy = "customer")
    private List<Policy> policies;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =Customer.this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public Integer getYearsAsCustomer() {
        return yearsAsCustomer;
    }

    public void setYearsAsCustomer(Integer yearsAsCustomer) {
        this.yearsAsCustomer = yearsAsCustomer;
    }

    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", creditScore=" + creditScore +
                ", yearsAsCustomer=" + yearsAsCustomer +
                '}';
    }
}

