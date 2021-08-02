package com.allstate.tacoman.customerinsurance.controller;

import com.allstate.tacoman.customerinsurance.dao.Customer;
import com.allstate.tacoman.customerinsurance.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @DeleteMapping("/customer/all")
    public void deleteCustomer() {
        customerService.deleteAll();
    }

}
