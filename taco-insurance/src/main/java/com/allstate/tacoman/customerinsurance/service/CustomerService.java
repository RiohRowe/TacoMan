package com.allstate.tacoman.customerinsurance.service;

import com.allstate.tacoman.customerinsurance.dao.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    List<Customer> createCustomers(List<Customer> customers);

    List<Customer> getAllCustomers();

    Customer getById(Long id);

    void deleteById(Long id);

    void deleteAll();
}
