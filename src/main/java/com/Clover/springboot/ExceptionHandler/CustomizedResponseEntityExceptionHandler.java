package com.Clover.springboot.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Clover.springboot.Model.ExceptionResponse;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler  {
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(StudentNotFoundException ex,WebRequest request){
		ExceptionResponse exceptionresponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false)
				,HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionresponse,HttpStatus.NOT_ACCEPTABLE);
		
	}

}


//@ExceptionHandler(BeanNotFoundException.class)
//public final ResponseEntity<ExceptionResponse> handleNotFoundException(BeanNotFoundException ex, WebRequest request) {
//  ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
//      request.getDescription(false),HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
//  return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
//}
