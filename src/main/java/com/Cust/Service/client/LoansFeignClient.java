package com.Cust.Service.client;

import com.Cust.DataTransferObject.LoanDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("LoansMicroService")
public interface LoansFeignClient {


    @GetMapping(value="api/fetch",consumes = "application/json")
    public ResponseEntity<LoanDTO> getLoan(@RequestBody Long loanId);


}
