package com.Clover.springboot.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class AspectCommonService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void getAspect1(){
		logger.info("Aspect Common Service :getAspect1 method");
		
	}
	
	public void getAspect2(){
		logger.info("Aspect Common Service :getAspect2 method");
		
	}

}
