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

    @PostMapping("/policy/quote")
    public PolicyQuoteResponseDTO getPremium() {
        PolicyQuoteResponseDTO quote = new PolicyQuoteResponseDTO(
                100.93,
                .01,
                "auto",
                "standard");
        return quote;
    }

    @PostMapping("/policy")
    public Policy createPolicy(@RequestBody PolicyRequestDTO request) {
        return policyService.createPolicy(request);
    }

    @PostMapping("/policy/create/many")
    public List<Policy> createPolicys(@RequestBody List<Policy> policys) {
        return policyService.createPolicys(policys);
    }

    @GetMapping("/policy/getall")
    public List<Policy> getAllPolicys() {
        return policyService.getAllPolicys();
    }
}