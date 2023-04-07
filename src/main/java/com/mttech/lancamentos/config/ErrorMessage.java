package com.mttech.lancamentos.config;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorMessage  {

    private HttpStatus status;
    private Integer codeError;
    private String message;
    
}
