package com.allstate.tacoman.customerinsurance.service;

import com.allstate.tacoman.customerinsurance.dao.Customer;
import com.allstate.tacoman.customerinsurance.dto.PolicyQuoteResponseDTO;
import com.allstate.tacoman.customerinsurance.dto.PolicyRequestDTO;
import com.allstate.tacoman.customerinsurance.exception.InvalidTypeException;
import com.allstate.tacoman.customerinsurance.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PolicyServiceTest {

    @InjectMocks
    private PolicyServiceImpl policyService;

    @Mock
    private CustomerService customerService;

    @BeforeEach
    public void beforeEach() {
        Customer customer = new Customer();
        customer.setAddress("123 Coolsvile st");
        customer.setAge(23);
        customer.setYearsAsCustomer(5);
        customer.setCreditScore(700);
        customer.setName("Kevin");
        customer.setSsn(122309832L);
        customer.setZipCode("55555");
        customer.setId(1L);
        Mockito.when(customerService.getById(1L)).thenReturn(customer);
    }

    @Test
    public void createQuote_ValidData() {
        PolicyRequestDTO requestDTO = new PolicyRequestDTO();
        requestDTO.setDeductible("high");
        requestDTO.setPolicyType("Home");
        requestDTO.setCoverageType("standard");
        requestDTO.setCustomerId(1L);
        PolicyQuoteResponseDTO quote = policyService.createQuote(requestDTO);

        Assertions.assertEquals("HOME", quote.getPolicyType());
        Assertions.assertEquals("STANDARD", quote.getCoverageType());
        Assertions.assertEquals(1000.00, quote.getDeductible());
        Assertions.assertEquals(60.8, quote.getPremium());
    }

    @Test
    public void createQuote_badDeductible() {
        PolicyRequestDTO requestDTO = new PolicyRequestDTO();
        requestDTO.setDeductible("highd");
        requestDTO.setPolicyType("Home");
        requestDTO.setCoverageType("standard");
        requestDTO.setCustomerId(1L);

        Assertions.assertThrows(InvalidTypeException.class, () -> {policyService.createQuote(requestDTO);});
    }

    @Test
    public void createQuote_badPolicyType() {
        PolicyRequestDTO requestDTO = new PolicyRequestDTO();
        requestDTO.setDeductible("high");
        requestDTO.setPolicyType("Homed");
        requestDTO.setCoverageType("standard");
        requestDTO.setCustomerId(1L);

        Assertions.assertThrows(InvalidTypeException.class, () -> {policyService.createQuote(requestDTO);});
    }

    @Test
    public void createQuote_badCoverageType() {
        PolicyRequestDTO requestDTO = new PolicyRequestDTO();
        requestDTO.setDeductible("high");
        requestDTO.setPolicyType("Home");
        requestDTO.setCoverageType("standardd");
        requestDTO.setCustomerId(1L);

        Assertions.assertThrows(InvalidTypeException.class, () -> {policyService.createQuote(requestDTO);});
    }
}
