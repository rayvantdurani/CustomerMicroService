package com.Cust.DataTransferObject;

import lombok.Data;

@Data
public class CustomerLoanDTO {

    private Long customerId;
    private String customerName;
    private CustomerDTO customerDTO;
    private LoanDTO loanDTO;



}
