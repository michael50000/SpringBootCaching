package com.Clover.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Clover.springboot.Model.Student;
import com.Clover.springboot.Services.CommonService;

@Controller
public class HelloController {
	
	@Autowired
	private CommonService cs;
	

   @RequestMapping("/")
   public String index() {
      return "AddForm";
   }

   @RequestMapping("/hello")
   public String sayHello(@RequestParam("name") String name, Model model) {
      model.addAttribute("name", name);
      return "hello";
   }
   
   @RequestMapping("/addForm")
   public String addForm() {
      return "AddForm";
   }
   
    
   //viewStudents
   
   @RequestMapping("/viewStudents")    
   public String viewemp(Model m){    
       List<Student> list=cs.getStudents();    
       m.addAttribute("list",list);  
       return "ViewStudent";    
   }    
   
   
   @RequestMapping("/users")    
   public String Users(Model m){    
	   m.addAttribute("name", "users");
	      return "hello";
      // return ("<h1>Hello user</h1>");    
   } 
   
   @RequestMapping("/admin")    
   public String Admin(Model m){    
	   m.addAttribute("name", "admin");
       return "hello";    
   }    


   
  
   
}
