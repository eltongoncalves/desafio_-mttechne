package com.mttech.lancamentos.config;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ErrorMessage {

    private HttpStatus status;
    private Integer codeError;
    private String message;

}
