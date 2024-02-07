package com.Cust.Service.Impl;

import com.Cust.DataTransferObject.CustomerDTO;
import com.Cust.Entity.Customer;
import com.Cust.Exception.CustomerAlreadyExists;
import com.Cust.Exception.ResourceNotFoundException;
import com.Cust.Mapper.CustomerMapper;
import com.Cust.Repository.MongoRepo;
import com.Cust.Service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private MongoRepo mongoRepo;
    @Override
    public void createCustomer(CustomerDTO customerDTO) {

        Customer customer = CustomerMapper.mapToCustomer(customerDTO,new Customer());
        Optional<Customer> optionalCustomer = mongoRepo.findByCustomerId(customer.getCustomerId());

        if(optionalCustomer.isPresent())
        {
            throw new CustomerAlreadyExists("Customer Already Exists");
        }else {
            mongoRepo.save(customer);
        }
    }

    @Override
    public CustomerDTO findCustomer(Long customerId) {

        Customer optionalCustomer = mongoRepo.findByCustomerId(customerId).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","Customer_ID",customerId));

        return CustomerMapper.mapToCustomerDTO(optionalCustomer,new CustomerDTO());

    }

    @Override
    public boolean updateCustomerDetails(CustomerDTO customerDTO) {
        boolean isUpdated= false;
        Long customerId = customerDTO.getCustomerId();
        Customer customer = CustomerMapper.mapToCustomer(customerDTO,new Customer());
        Customer oldCustomer  = mongoRepo.findByCustomerId(customerId).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","Customer ID",customerId)
        );

        Customer updatedCustomner=CustomerMapper.mapUpdatedDetailsCustomer(oldCustomer,customer);
        mongoRepo.save(updatedCustomner);

        isUpdated=true;
        return isUpdated;
    }

    @Override
    public void deletCustomer(Long customerId) {

        Customer userTobeDeleted = mongoRepo.findByCustomerId(customerId).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","Customer ID",customerId)
        );

        mongoRepo.deleteByCustomerId(userTobeDeleted.getCustomerId());

    }


}
