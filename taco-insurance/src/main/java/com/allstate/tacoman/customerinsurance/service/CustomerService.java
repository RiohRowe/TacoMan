package com.allstate.tacoman.customerinsurance.service;
import com.allstate.tacoman.customerinsurance.dao.Customer;
import javax.management.InstanceNotFoundException;
import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public List<Customer> createCustomers(List<Customer> customers);
    public List<Customer> getAllCustomers();
    public Customer getById(Long id);
    public void deleteById(Long id);
    public void deleteAll();
}
