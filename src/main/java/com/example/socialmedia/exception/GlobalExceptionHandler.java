package com.example.socialmedia.exception;

import com.example.socialmedia.dto.ErrorDto;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDto> handleDefaultHandlerExceptionResolver(MethodArgumentNotValidException exception) {
        List<ErrorDto> errorList = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getFieldErrors();
        for (FieldError error : fieldErrors) { // Password, Name
            String field = error.getField();
            String defaultMessage = error.getDefaultMessage();
            ErrorDto errorDto = new ErrorDto();
            errorDto.setField(field);
            errorDto.setMessage(defaultMessage);
            errorList.add(errorDto);
        }
        return errorList;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDto handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        String message = userNotFoundException.getMessage();
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(message);
        return errorDto;
    }
}