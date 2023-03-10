package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myNHFException(NoHandlerFoundException nhf, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setMessage(nhf.getMessage());
		err.setDate(LocalDateTime.now());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> MyMANVException(MethodArgumentNotValidException manv){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDate(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(manv.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception exception, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDate(LocalDateTime.now());
		err.setMessage(exception.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(URLExpiredException.class)
	public ResponseEntity<MyErrorDetails> URLEException(URLExpiredException urlee, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDate(LocalDateTime.now());
		err.setMessage(urlee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(URLInvalidException.class)
	public ResponseEntity<MyErrorDetails> URLIException(URLInvalidException urlie, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDate(LocalDateTime.now());
		err.setMessage(urlie.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
}
