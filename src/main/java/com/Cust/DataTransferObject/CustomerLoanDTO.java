package com.Cust.DataTransferObject;

import lombok.Data;

@Data
public class CustomerLoanDTO {

    private Long customerId;
    private CustomerDTO customerDTO;
    private LoanDTO loanDTO;



}
