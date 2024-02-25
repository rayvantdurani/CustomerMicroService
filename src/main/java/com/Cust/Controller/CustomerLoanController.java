package com.Cust.Controller;


import com.Cust.DataTransferObject.CustomerLoanDTO;
import com.Cust.Service.ILoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "${base.url}",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerLoanController {

    @Autowired
    private ILoansService iLoansService;

    @GetMapping("/fetchLoans")
    public ResponseEntity<CustomerLoanDTO> fetchCustomerDetails(@RequestParam Long customerId)
    {
        CustomerLoanDTO customerLoanDTO=  iLoansService.fetchLoans(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customerLoanDTO);
    }
}
