package com.Cust.Controller;

import com.Cust.Constants.CustomerConstants;
import com.Cust.DataTransferObject.CustomerDTO;
import com.Cust.DataTransferObject.ResponseDTO;
import com.Cust.Service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${base.url}",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CustomerController {

    private ICustomerService iCustomerService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createCustomer(@RequestBody CustomerDTO customerDTO)
    {
        iCustomerService.createCustomer(customerDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(CustomerConstants.STATUS_201,CustomerConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchDetails(@RequestParam Long customerId)
    {
       CustomerDTO customerDTO = iCustomerService.findCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateCustomerRecords(@RequestBody CustomerDTO customerdto)
    {
       iCustomerService.updateCustomerDetails(customerdto);

       return ResponseEntity.status(HttpStatus.ACCEPTED)
               .body(new ResponseDTO(CustomerConstants.STATUS_200,CustomerConstants.MESSAGE_200));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteUser(@RequestParam Long customerId)
    {
        iCustomerService.deletCustomer(customerId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDTO(CustomerConstants.STATUS_200,CustomerConstants.MESSAGE_200));
    }





}
