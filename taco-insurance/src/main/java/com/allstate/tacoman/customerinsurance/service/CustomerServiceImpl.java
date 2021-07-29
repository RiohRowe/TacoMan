package com.allstate.tacoman.customerinsurance.service;

import com.allstate.tacoman.customerinsurance.dao.Customer;
import com.allstate.tacoman.customerinsurance.exception.IdNotFoundException;
import com.allstate.tacoman.customerinsurance.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public Customer createCustomer(Customer customer) {
    return customerRepo.save(customer);
}

    @Override
    public List<Customer> createCustomers(List<Customer> customers) {
        return customerRepo.saveAll(customers);
}

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll(Sort.by("name"));
}

    @Override
    public Customer getById(Long id) {
        Optional<Customer> optionalCustomer = customerRepo.findById(id);
        if(optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        else {
            throw new IdNotFoundException(String.format("Customer with ID [%s] not found.", id));
        }
}
    @Override
    public void deleteById(Long id) {
        customerRepo.deleteById(id);
}
    @Override
    public void deleteAll() {
        customerRepo.deleteAll();
}
}
