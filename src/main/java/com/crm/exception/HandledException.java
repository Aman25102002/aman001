package com.crm.exception;

import com.crm.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

//Catch Block
@ControllerAdvice
public class HandledException {

    //Handle exception for employee not found
//    @ExceptionHandler(ResourceNotFound.class)
//    public ResponseEntity<String> handleEmployeeNotFoundException(ResourceNotFound e) {
//
//        return new ResponseEntity<>("Record not found", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(ResourceNotFound.class)
//    public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(ResourceNotFound e, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),request.getDescription(true));
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(Exception.class)   //It can handle all type of Exception
    public ResponseEntity<ErrorDetails> globalException(Exception e, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
