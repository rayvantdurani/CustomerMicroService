package com.Cust.Service.Impl;

import com.Cust.DataTransferObject.CustomerDTO;
import com.Cust.DataTransferObject.CustomerLoanDTO;
import com.Cust.DataTransferObject.LoanDTO;
import com.Cust.Entity.Customer;
import com.Cust.Exception.ResourceNotFoundException;
import com.Cust.Mapper.CustomerMapper;
import com.Cust.Repository.CustomerRepository;
import com.Cust.Service.ILoansService;
import com.Cust.Service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerLoansImpl implements ILoansService {


    private CustomerRepository customerRepository;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerLoanDTO fetchCustomerLoans(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId).orElseThrow(
                ()-> new ResourceNotFoundException(customerId.toString())
        );
        CustomerLoanDTO customerLoanDTO = CustomerMapper.mapToCustomerDetailsDTO(customer,new CustomerLoanDTO());
        customerLoanDTO.setCustomerDTO(CustomerMapper.mapToCustomerDTO(customer,new CustomerDTO()));




        ResponseEntity<LoanDTO> loansDTOResponseEntity=loansFeignClient.getLoan(customerId);
        customerLoanDTO.setLoanDTO(loansDTOResponseEntity.getBody());

        return customerLoanDTO;

    }
}
