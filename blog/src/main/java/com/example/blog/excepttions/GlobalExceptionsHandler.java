package com.example.blog.excepttions;

import com.example.blog.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionsHandler {

//    this method is to create custom response for new custom created exception

    @ExceptionHandler(ResourceNotfoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(
            ResourceNotfoundException ex){
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

//     this method is to create custom response on a predefined exception

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> errorResponse = new HashMap<>();
        ex.getBindingResult()
                .getAllErrors()
                .forEach(
                        (objectError) -> {
                            String fieldName = ((FieldError)objectError).getField();
                            String errorMessage = objectError.getDefaultMessage();
                            errorResponse.put(fieldName, errorMessage);
                        }
                );

        return new ResponseEntity<Map<String, String>>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
