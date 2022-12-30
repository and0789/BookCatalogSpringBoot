package com.itc.bookcatalogv2.exceptions;


import com.itc.bookcatalogv2.dto.ErrorResponseDTO;
import com.itc.bookcatalogv2.enums.ErrorCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException (ResourceNotFoundException ex, WebRequest request){
        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());
        ErrorResponseDTO errorResponse = ErrorResponseDTO.of("data not found", details, ErrorCode.DATA_NOTFOUND, HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(errorResponse);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        List<String> details = new ArrayList<String>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()){
            details.add(error.getDefaultMessage());
        }
        ErrorResponseDTO errorResponse = ErrorResponseDTO.of("invalid data", details, ErrorCode.INVALID_DATA, HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
