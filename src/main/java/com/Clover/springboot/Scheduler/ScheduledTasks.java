package com.Clover.springboot.Scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class ScheduledTasks {
	Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	@Scheduled(fixedRate=10000) //for every ten seconds
	public void performTask(){
		
		logger.info("Regular task performed"+dateFormat.format(new Date()));
		
	}
	
	@Scheduled(initialDelay = 1000, fixedRate = 10000) //Initial delay with one sec and then perform task
	public void performDelayedTask() {

		logger.info("Delayed Regular task performed at "
				+ dateFormat.format(new Date()));

	}
	
	
	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void performTaskUsingCron() {

		logger.info("Regular task performed using Cron at "
				+ dateFormat.format(new Date()));

	}
	
	

}
