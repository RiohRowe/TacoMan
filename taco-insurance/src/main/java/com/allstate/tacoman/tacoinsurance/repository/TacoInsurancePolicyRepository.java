package com.allstate.tacoman.tacoinsurance.repository;

import com.allstate.tacoman.tacoinsurance.dao.TacoInsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoInsurancePolicyRepository extends JpaRepository<TacoInsurancePolicy, Long> {
}
