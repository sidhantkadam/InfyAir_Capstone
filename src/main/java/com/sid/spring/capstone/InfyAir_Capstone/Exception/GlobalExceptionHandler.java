package com.sid.spring.capstone.InfyAir_Capstone.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ErrorInfo> invalidUser(InvalidUserException invalidUserException, WebRequest webRequest)
    {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage(invalidUserException.getMessage());
        errorInfo.setErrorCode(HttpStatus.UNAUTHORIZED);
        errorInfo.setLocalDateTime(LocalDateTime.now());
        errorInfo.setInfo(webRequest.getDescription(false));
        return new ResponseEntity<>(errorInfo, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserAlreadyPresent.class)
    public ResponseEntity<ErrorInfo> userAlreadyPresent(UserAlreadyPresent userAlreadyPresent, WebRequest webRequest)
    {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage(userAlreadyPresent.getMessage());
        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST);
        errorInfo.setLocalDateTime(LocalDateTime.now());
        errorInfo.setInfo(webRequest.getDescription(false));
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> normalException(Exception e, WebRequest webRequest)
    {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage(e.getMessage());
        errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR);
        errorInfo.setLocalDateTime(LocalDateTime.now());
        errorInfo.setInfo(webRequest.getDescription(false));
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
