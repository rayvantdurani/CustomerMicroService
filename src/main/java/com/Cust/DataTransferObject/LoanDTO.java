package com.Cust.DataTransferObject;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class LoanDTO {


    private Long loanId;
    private Long customerId;
    private Long loanAmount;
    private String baseBank;
    private int tenor;



}

