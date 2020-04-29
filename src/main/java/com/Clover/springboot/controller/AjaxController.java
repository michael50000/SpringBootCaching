package com.Clover.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Clover.springboot.Model.Student;
import com.Clover.springboot.Services.CommonService;

@Controller
public class AjaxController {
	
	@Autowired
	private CommonService cs;
	
	
	@RequestMapping(value="/insertData" ,method = RequestMethod.POST)     
	@ResponseBody
	public String check(@RequestParam String name,@RequestParam String email,@RequestParam String dept) {
		String s; 
		System.out.println(name);
		System.out.println(email);
		System.out.println(dept);
		s=cs.insertStudentData(name, email, dept);
		return s;
	  
	}
	
	
	@RequestMapping(value="/DeleteStd" ,method = RequestMethod.POST)     
	@ResponseBody
	public String check(@RequestParam Integer stid) {
		String s; 
		System.out.println(stid);
		s=cs.deleteStudent(stid);
		
		return s;
	  
	}
	
	@RequestMapping(value="/updateStudent" ,method = RequestMethod.POST)     
	@ResponseBody
	public String updateStudent(@RequestParam Integer stid,@RequestParam String name,@RequestParam String email,@RequestParam String dept) {
		String s; 
		System.out.println(name);
		System.out.println(email);
		System.out.println(dept);
		s=cs.updateStudent(stid,name, email, dept);
		return s;
	  
	}
	
	
	@RequestMapping(value="/checkcsrfaddemp" ,method = RequestMethod.POST)     
	public String checkCsrf(@RequestParam String name,@RequestParam String email,@RequestParam String dept) {
		String s; 
		System.out.println(name);
		System.out.println(email);
		System.out.println(dept);
		s=cs.insertStudentData(name, email, dept);
		return s;
	  
	}
	
	
	
	
	  
	

}
