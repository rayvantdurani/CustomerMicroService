package com.Cust.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Data
public class Loan {


    private Long loanId;
    private Long customerId;
    private Long loanAmount;
    private String baseBank;
    private int tenor;

    @CreatedDate
    private LocalDateTime createAt;

    @CreatedBy
    private String createdBy;


    @LastModifiedDate
    private LocalDateTime lastModifiedTime;

    @org.springframework.data.annotation.LastModifiedBy
    private String LastModifiedBy;
}
