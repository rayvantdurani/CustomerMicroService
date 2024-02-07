package com.Cust.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName,String fieldName, Long fieldValue)
    {
        super(String.format("%s not found based on %s data :%S",resourceName,fieldName,fieldValue));

    }
}
