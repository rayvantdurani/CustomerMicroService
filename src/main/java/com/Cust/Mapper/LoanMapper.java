package com.Cust.Mapper;

import com.Cust.DataTransferObject.LoanDTO;
import com.Cust.Entity.Loan;

public class LoanMapper {
    private LoanMapper(){
        }


    public static LoanDTO maptoLoanDTO(Loan loan, LoanDTO loanDTO)
    {
        loanDTO.setLoanAmount(loan.getLoanAmount());
        loanDTO.setCustomerId(loan.getCustomerId());
        loanDTO.setTenor(loan.getTenor());
        loanDTO.setBaseBank(loan.getBaseBank());
        loanDTO.setLoanId(loan.getLoanId());
        return loanDTO;
    }
}
