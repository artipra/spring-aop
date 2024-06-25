package com.example.springaop.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDto{

    private String message;
    private HttpStatus httpStatus;


}
