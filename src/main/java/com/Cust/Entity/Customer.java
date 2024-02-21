package com.Cust.Entity;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


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

    @CreatedDate
    private LocalDateTime createdTime;
    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;

    @LastModifiedBy
    private String lastModifiedBy;



}
