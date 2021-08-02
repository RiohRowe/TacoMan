package com.allstate.tacoman.customerinsurance.controller;

import com.allstate.tacoman.customerinsurance.dao.Policy;
import com.allstate.tacoman.customerinsurance.dto.PolicyQuoteResponseDTO;
import com.allstate.tacoman.customerinsurance.dto.PolicyRequestDTO;
import com.allstate.tacoman.customerinsurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/policy/all")
    public List<Policy> getAllPoliciesByCustomerId(@RequestParam(required = false) Long customerId) {
       return customerId != null?
               policyService.getAllByCustomerId(customerId) :
               policyService.getAllPolicies();
               //Comment by Shar
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