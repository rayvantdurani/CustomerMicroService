package com.Cust.Service.Impl;

import com.Cust.DataTransferObject.CustomerDTO;
import com.Cust.Entity.Customer;
import com.Cust.Exception.CustomerAlreadyExists;
import com.Cust.Exception.ResourceNotFoundException;
import com.Cust.Mapper.CustomerMapper;
import com.Cust.Repository.CustomerRepository;
import com.Cust.Service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;


@Service@AllArgsConstructor
public class ICustomerServicesImpl implements ICustomerService {

    private CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO,new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerId(customer.getCustomerId());
        if(optionalCustomer.isPresent())
        {
            throw new CustomerAlreadyExists("Customer Already Exists");
        }
        else {
            customer.setCreatedTime(LocalDateTime.now());
            customer.setCreatedBy("NEW_ACCOUNT");
            customerRepository.save(customer);
        }

    }

    @Override
    public CustomerDTO findCustomer(Long customerId) {
        Customer optionalCustomer = customerRepository.findByCustomerId(customerId).orElseThrow(
                ()-> new ResourceNotFoundException(customerId.toString()));
        return CustomerMapper.mapToCustomerDTO(optionalCustomer,new CustomerDTO());

    }

    @Override
    public boolean updateCustomerDetails(CustomerDTO customerDTO) {
        boolean isUpdated= false;
        Customer customer = CustomerMapper.mapToCustomer(customerDTO,new Customer());
        Long customerId = customer.getCustomerId();
        Customer oldCustomer  = customerRepository.findByCustomerId(customerId).orElseThrow(
                ()-> new ResourceNotFoundException(customerId.toString())
        );
        CustomerMapper.mapToCustomerDTO(oldCustomer,customerDTO);
        oldCustomer.setLastModifiedBy("ADMIN");
        oldCustomer.setLastUpdatedTime(LocalDateTime.now());
        customerRepository.save(oldCustomer);
        isUpdated=true;
        return isUpdated;
    }

    @Override
    public void deletCustomer(Long customerId) {

        Customer userTobeDeleted = customerRepository.findByCustomerId(customerId).orElseThrow(
                ()-> new ResourceNotFoundException("Customer Not Found")
        );
        customerRepository.deleteByCustomerId(userTobeDeleted.getCustomerId());

    }


}
