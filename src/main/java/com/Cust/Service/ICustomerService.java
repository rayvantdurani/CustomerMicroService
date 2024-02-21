package com.Cust.Service;

import com.Cust.DataTransferObject.CustomerDTO;


public interface ICustomerService {


    /**
     *
     * @param customerDTO
     */
    void createCustomer(CustomerDTO customerDTO);

    CustomerDTO findCustomer(Long customerId);

    boolean updateCustomerDetails(CustomerDTO customerDTO);

    void deletCustomer(Long customerId);


}
