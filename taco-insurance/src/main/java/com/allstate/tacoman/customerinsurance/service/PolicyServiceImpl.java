package com.allstate.tacoman.customerinsurance.service;

import com.allstate.tacoman.customerinsurance.dao.Customer;
import com.allstate.tacoman.customerinsurance.dao.Policy;
import com.allstate.tacoman.customerinsurance.dto.PolicyRequestDTO;
import com.allstate.tacoman.customerinsurance.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.management.InstanceNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepo;

    @Autowired
    private CustomerService customerService;

    @Override
    public Policy createPolicy(PolicyRequestDTO policyData) {

        Customer customer = customerService.getById(policyData.getCustomerId());

        Policy policy = new Policy();
        policy.setPolicyType(policyData.getPolicyType());
        policy.setPolicyNumber("1234");
        policy.setCoverageType(policyData.getPolicyType());
        policy.setDeductible(policyData.getDeductible());
        policy.setPremium(100.98);
        policy.setEffectiveDate(new Date());
        policy.setProcessDate(new Date());
        policy.setCustomer(customer);
        return policyRepo.save(policy);
    }

    @Override
    public List<Policy> createPolicys(List<Policy> policys) {
        return policyRepo.saveAll(policys);
    }

    @Override
    public List<Policy> getAllPolicys() {
        return policyRepo.findAll(Sort.by("name"));
    }

    @Override
    public Policy getById(Long id) throws InstanceNotFoundException {
        Optional<Policy> optionalPolicy = policyRepo.findById(id);
        if(optionalPolicy.isPresent()) {
            return optionalPolicy.get();
        }
        else {
            throw new InstanceNotFoundException();
        }
    }

    @Override
    public void deleteById(Long id) {
        policyRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        policyRepo.deleteAll();
    }
}