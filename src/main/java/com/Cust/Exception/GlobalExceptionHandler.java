package com.Cust.Exception;

import com.Cust.DataTransferObject.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistException(Exception
                                                                                        exception,
                                                                                WebRequest webRequest)
    {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDTO,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerAlreadyExists.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistException(CustomerAlreadyExists
                                                                                customerAlreadyExists,
                                                                                WebRequest webRequest)
    {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                customerAlreadyExists.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDTO,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistException(ResourceNotFoundException
                                                                                        resourceNotFoundException,
                                                                                WebRequest webRequest)
    {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                resourceNotFoundException.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDTO,HttpStatus.BAD_REQUEST);
    }


}
