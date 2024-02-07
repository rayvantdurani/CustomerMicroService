package com.Cust.Entity;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@Document(collection = "CustomerDetails")
public class Customer {


    @NotNull
    @MongoId
    private Long customerId;

    @NotNull
    private String name;

    
    private String password;
    private String role;

//    private LocalDateTime createdTime;
//
//    private LocalDateTime lastUpdatedTime;
//
//    private String updatedBy;
//
//    private String lastModifiedBy;



}
