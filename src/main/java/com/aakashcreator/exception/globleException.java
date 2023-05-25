package com.aakashcreator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aakashcreator.payload.ApiResponse;

@RestControllerAdvice
public class globleException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResorceNotFoundException(ResourceNotFoundException ex){
		
	    String msg=ex.getMessage();
	ApiResponse response=ApiResponse.builder().msg(msg).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
