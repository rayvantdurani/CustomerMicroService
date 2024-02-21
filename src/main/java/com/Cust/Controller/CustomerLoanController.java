package com.Cust.Controller;


import com.Cust.DataTransferObject.CustomerLoanDTO;
import com.Cust.Service.ILoansService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name="Customer Loan Controller",
        description="This is a Customer Controller having Loans Information"
)
@RestController
@RequestMapping(value = "${base.url}",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerLoanController {

    @Autowired
    private ILoansService iLoansService;

    @GetMapping("/fetchLoans")
    public ResponseEntity<CustomerLoanDTO> fetchCustomerDetails(@RequestBody Long customerId)
    {
        CustomerLoanDTO customerLoanDTO=  iLoansService.fetchCustomerLoans(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customerLoanDTO);
    }
}
