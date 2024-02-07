package com.Cust.Mapper;

import com.Cust.DataTransferObject.CustomerDTO;
import com.Cust.Entity.Customer;

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
        return customer;
    }

    public static Customer mapUpdatedDetailsCustomer(Customer oldCustomer,Customer updatedCustomer)
    {
        oldCustomer.setPassword(updatedCustomer.getPassword());
        oldCustomer.setName(updatedCustomer.getName());
        oldCustomer.setRole(updatedCustomer.getRole());
        return oldCustomer;
    }



}
