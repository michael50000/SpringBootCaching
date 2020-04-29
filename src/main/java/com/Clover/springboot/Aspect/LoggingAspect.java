package com.Clover.springboot.Aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.Clover.springboot.Model.Student;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*@Before("getAllStudents()")
	public void loggingAdvice(JoinPoint jp){
		//System.out.println("Inside logging aspect");
		logger.info("Inside logging aspect");
		logger.info(jp.toString());
		logger.info(jp.getTarget().toString());
		
	}
	*/
	@Pointcut("execution(public * getStudents())")
	public void getAllStudents(){
		
	}
	
	/*@After("getAllStudents()")
	public void loggingAfterAdvice(JoinPoint jp){
		//System.out.println("Inside logging aspect");
		logger.info("Inside AfterAdvice logging aspect");
		logger.info("=================================");
		logger.info("Inside AfterAdvice logging aspect");
		
		
	}*/
	
	@Around("getAllStudents()")  
    public Object myadvice(ProceedingJoinPoint pjp) throws Throwable   
    {  
        System.out.println("Additional Concern Before calling actual method");  
        Object obj=pjp.proceed();  
        System.out.println("Additional Concern After calling actual method");  
        return obj;  
    }  
	
	
	
	

}
