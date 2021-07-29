package com.allstate.tacoman.tacoinsurance.repository;

import com.allstate.tacoman.tacoinsurance.dao.PolicyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyTypeRepository extends JpaRepository<PolicyType, Long> {
}
