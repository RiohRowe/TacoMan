package com.allstate.tacoman.customerinsurance.service;

import com.allstate.tacoman.customerinsurance.dao.Policy;
import com.allstate.tacoman.customerinsurance.dto.PolicyRequestDTO;
import org.springframework.data.domain.Sort;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

public interface PolicyService {
    public Policy createPolicy(PolicyRequestDTO policyData);
    public List<Policy> getAllPolicies();
    public List<Policy> getAllByCustomerId(Long id);
    public Policy getById(Long id) throws InstanceNotFoundException;
    public void deleteById(Long id);
    public void deleteAll();
}
