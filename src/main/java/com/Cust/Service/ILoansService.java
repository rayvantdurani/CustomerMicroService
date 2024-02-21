package com.Cust.Service;

import com.Cust.DataTransferObject.CustomerLoanDTO;


public interface ILoansService {

    /**
     * This will return consolidated record for the CustomerLoan Details
     * @param customerId
     * @return
     */
    CustomerLoanDTO fetchCustomerLoans(Long customerId);
}
