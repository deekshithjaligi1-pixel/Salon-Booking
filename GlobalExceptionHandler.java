package com.SaloonBookingSystem.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.SaloonBookingSystem.payload.responce.ExceptionResponce;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponce> ExceptionHandler(Exception ex,WebRequest req){
		
		ExceptionResponce responce = new ExceptionResponce(
				ex.getMessage(),
				req.getDescription(false),LocalDateTime.now()
		);
		return ResponseEntity.ok(responce);
	}
	
}