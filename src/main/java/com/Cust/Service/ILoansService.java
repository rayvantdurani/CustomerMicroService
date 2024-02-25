package com.Cust.Service;

import com.Cust.DataTransferObject.CustomerDTO;
import com.Cust.DataTransferObject.CustomerLoanDTO;
import com.Cust.DataTransferObject.LoanDTO;

public interface ILoansService {


    CustomerLoanDTO fetchLoans(Long customerId);
}
