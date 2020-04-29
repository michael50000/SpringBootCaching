package com.Clover.springboot;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.Clover.springboot.Services.CommonService;

@SpringBootApplication
//@EnableScheduling
//@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableCaching
public class MainApp {
	
   public static void main(String[] args) {
      SpringApplication.run(MainApp.class, args);
      CommonService cs=new CommonService();
      
      System.out.println(cs.getStudents());
      //System.out.println("=============Delete list================");
      //cs.delete(3);
      //System.out.println("=============Delete list=======d=========");
      
      
      
      
   } 
}
