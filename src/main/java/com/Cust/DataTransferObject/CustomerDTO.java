package com.Cust.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data

public class CustomerDTO {


    @MongoId
    private Long customerId;
    private String name;
    private String password;
    private String role;


}
