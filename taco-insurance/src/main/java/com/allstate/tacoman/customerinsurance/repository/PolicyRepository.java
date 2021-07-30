package com.allstate.tacoman.customerinsurance.repository;

import com.allstate.tacoman.customerinsurance.dao.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> getAllByCustomerId(Long customerId);
}
