package com.allstate.tacoman.customerinsurance.service;

import com.allstate.tacoman.customerinsurance.dao.*;
import com.allstate.tacoman.customerinsurance.dto.PolicyQuoteResponseDTO;
import com.allstate.tacoman.customerinsurance.dto.PolicyRequestDTO;
import com.allstate.tacoman.customerinsurance.exception.InvalidTypeException;
import com.allstate.tacoman.customerinsurance.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
            throw new InvalidTypeException(String.format("[%s] is not a valid policy type.", policyData.getPolicyType().toUpperCase()));
        }
        try {
            policy.setCoverageType(CoverageType.valueOf(policyData.getCoverageType().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new InvalidTypeException(String.format("[%s] is not a valid coverage type.", policyData.getCoverageType().toUpperCase()));
        }
        try {
            policy.setDeductible(DeductibleType.valueOf(policyData.getDeductible().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new InvalidTypeException(String.format("[%s] is not a valid deductible type.", policyData.getDeductible().toUpperCase()));
        }
        policy.setPolicyNumber(UUID.randomUUID().toString());
        Double premium = policy.getPolicyType().getBaseRate() * policy.getCoverageType().getMultiplier() * policy.getDeductible().getMultiplier();
        premium *= calculateDiscountMultiplier(customer.getAge(),customer.getYearsAsCustomer(),customer.getCreditScore());
        BigDecimal bd = BigDecimal.valueOf(premium);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        policy.setPremium(bd.doubleValue());
        policy.setEffectiveDate(new Date(new Date().getTime() + WEEK_IN_MS));
        policy.setProcessDate(new Date());
        policy.setCustomer(customer);
        return policy;
    }

    private double calculateDiscountMultiplier(int age, int yearsAsCustomer, int creditScore) {
        double multiplier = 1.0;

        multiplier -= (age>25)?0.05:0.0;
        multiplier -= yearsAsCustomer * .01;
        multiplier -= (creditScore > 700)?0.05:0.0;

        return Math.max(.8, multiplier);
    }
}