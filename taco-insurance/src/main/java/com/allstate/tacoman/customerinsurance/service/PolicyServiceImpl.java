package com.allstate.tacoman.customerinsurance.service;

import com.allstate.tacoman.customerinsurance.dao.CoverageType;
import com.allstate.tacoman.customerinsurance.dao.Customer;
import com.allstate.tacoman.customerinsurance.dao.Policy;
import com.allstate.tacoman.customerinsurance.dao.PolicyType;
import com.allstate.tacoman.customerinsurance.dto.PolicyQuoteResponseDTO;
import com.allstate.tacoman.customerinsurance.dto.PolicyRequestDTO;
import com.allstate.tacoman.customerinsurance.exception.InvalidTypeException;
import com.allstate.tacoman.customerinsurance.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.*;

@Service
public class PolicyServiceImpl implements PolicyService {

    private static final long WEEK_IN_MS = 604800000;

    @Autowired
    private PolicyRepository policyRepo;

    @Autowired
    private CustomerService customerService;

    @Override
    public Policy createPolicy(PolicyRequestDTO policyData) {

        Customer customer = customerService.getById(policyData.getCustomerId());
        return policyRepo.save(generatePolicy(customer, policyData));

    }

    @Override
    public PolicyQuoteResponseDTO createQuote(PolicyRequestDTO policyData) {
        Customer customer = customerService.getById(policyData.getCustomerId());
        return new PolicyQuoteResponseDTO(generatePolicy(customer, policyData));
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepo.findAll();
    }

    @Override
    public List<Policy> getAllByCustomerId(Long id) {
        return policyRepo.getAllByCustomerId(id);
    }

    @Override
    public Policy getById(Long id) throws InstanceNotFoundException {
        Optional<Policy> optionalPolicy = policyRepo.findById(id);
        if (optionalPolicy.isPresent()) {
            return optionalPolicy.get();
        } else {
            throw new InstanceNotFoundException();
        }
    }

    @Override
    public void deleteById(Long id) {
        policyRepo.deleteById(id);
    }

    private Policy generatePolicy(Customer customer, PolicyRequestDTO policyData) {
        Policy policy = new Policy();
        try {
            policy.setPolicyType(PolicyType.valueOf(policyData.getPolicyType().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new InvalidTypeException(String.format("[%s] is not a valid policy type.", policyData.getPolicyType().toUpperCase(Locale.ROOT)));
        }
        try {
            policy.setCoverageType(CoverageType.valueOf(policyData.getCoverageType().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new InvalidTypeException(String.format("[%s] is not a valid coverage type.", policyData.getCoverageType().toUpperCase(Locale.ROOT)));
        }
        policy.setDeductible(policyData.getDeductible());
        policy.setPolicyNumber(UUID.randomUUID().toString());
        policy.setPremium(100.98);
        policy.setEffectiveDate(new Date(new Date().getTime() + WEEK_IN_MS));
        policy.setProcessDate(new Date());
        policy.setCustomer(customer);
        return policy;
    }

}