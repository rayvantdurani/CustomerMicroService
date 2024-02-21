package com.Cust.Mapper;

import com.Cust.DataTransferObject.CustomerDTO;
import com.Cust.DataTransferObject.CustomerLoanDTO;
import com.Cust.Entity.Customer;

import java.time.LocalDateTime;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDTO(Customer customer, CustomerDTO customerDTO)
    {
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setRole(customer.getRole());
        return customerDTO;
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO, Customer customer)
    {
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setName(customerDTO.getName());
        customer.setPassword(customerDTO.getPassword());
        customer.setRole(customerDTO.getRole());
        customer.setLastModifiedBy("ADMIN");
        customer.setLastUpdatedTime(LocalDateTime.now());
        return customer;
    }

    public static CustomerLoanDTO mapToCustomerDetailsDTO(Customer customer, CustomerLoanDTO customerLoanDTO)
    {
        customerLoanDTO.setCustomerId(customer.getCustomerId());
        customerLoanDTO.setCustomerName(customer.getName());
        return customerLoanDTO;

    }







}
