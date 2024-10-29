package com.sid.spring.capstone.InfyAir_Capstone.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorInfo
{
    String errorMessage;
    HttpStatus errorCode;
    LocalDateTime localDateTime;
    String info;
}
