package com.allstate.tacoman.customerinsurance.service;

import com.allstate.tacoman.customerinsurance.dao.Policy;
import com.allstate.tacoman.customerinsurance.dto.PolicyQuoteResponseDTO;
import com.allstate.tacoman.customerinsurance.dto.PolicyRequestDTO;

import javax.management.InstanceNotFoundException;
import java.util.List;

public interface PolicyService {
    Policy createPolicy(PolicyRequestDTO policyData);
    PolicyQuoteResponseDTO createQuote(PolicyRequestDTO policyData);
    List<Policy> getAllPolicies();
    List<Policy> getAllByCustomerId(Long id);
    Policy getById(Long id) throws InstanceNotFoundException;
    void deleteById(Long id);
}
