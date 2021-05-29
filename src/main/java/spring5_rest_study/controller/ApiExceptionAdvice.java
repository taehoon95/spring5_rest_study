package spring5_rest_study.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import spring5_rest_study.dto.ErrorResponse;
import spring5_rest_study.exception.MemberNotFoundException;

@RestControllerAdvice("spring5_rest_study.controller")
public class ApiExceptionAdvice {
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoData(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
	}
}
