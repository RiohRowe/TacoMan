package com.allstate.tacoman.customerinsurance.controller;

import com.allstate.tacoman.customerinsurance.dao.CoverageType;
import com.allstate.tacoman.customerinsurance.dao.DeductibleType;
import com.allstate.tacoman.customerinsurance.dao.Policy;
import com.allstate.tacoman.customerinsurance.dao.PolicyType;
import com.allstate.tacoman.customerinsurance.dto.PolicyQuoteResponseDTO;
import com.allstate.tacoman.customerinsurance.dto.PolicyRequestDTO;
import com.allstate.tacoman.customerinsurance.dto.PolicyTypesResponseDTO;
import com.allstate.tacoman.customerinsurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/policy/all")
    public List<Policy> getAllPoliciesByCustomerId(@RequestParam(required = false) Long customerId) {
       return customerId != null?
               policyService.getAllByCustomerId(customerId) :
               policyService.getAllPolicies();
    }

    @GetMapping("policy/types/all")
    public PolicyTypesResponseDTO getAllPolicyTypes() {
        return new PolicyTypesResponseDTO();
    }

    @PostMapping("/policy/quote")
    public PolicyQuoteResponseDTO generateQuote(@RequestBody PolicyRequestDTO policyData) {
        return policyService.createQuote(policyData);
    }

    @PostMapping("/policy")
    public Policy createPolicy(@RequestBody PolicyRequestDTO request) {
        return policyService.createPolicy(request);
    }

    @DeleteMapping("policy/{policyId}")
    public void deletePolicy(@PathVariable Long policyId) {
        policyService.deleteById(policyId);
    }


}