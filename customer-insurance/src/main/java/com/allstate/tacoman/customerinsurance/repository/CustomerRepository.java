package com.allstate.tacoman.customerinsurance.repository;

import com.allstate.tacoman.customerinsurance.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
