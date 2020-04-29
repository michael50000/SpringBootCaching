package com.Clover.springboot.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Clover.springboot.Cacing.CacheService;
import com.Clover.springboot.ExceptionHandler.StudentNotFoundException;
import com.Clover.springboot.HibernateUtil.HibernateUtil;
import com.Clover.springboot.Model.Student;
import com.Clover.springboot.Model.Workers;

@RestController
public class JsonController {
	
	@Autowired
	private CacheService cs;
	
	@RequestMapping(value = "/api/getStudents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> getStudents() {
	    
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           return session.createQuery("from Student", Student.class).list();
        }
	}
	
	
	@RequestMapping(value = "/api/getStudents/{sid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> getStudentsbyid(@PathVariable(value = "sid") Integer sid) {
	    
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           Query q= session.createQuery("select s from Student s where s.sid = :sid");
           q.setParameter("sid", sid);
           List<Student>st=q.list();
           if(st!=null && st.size()<=0){
        	   throw new StudentNotFoundException("Student: "+sid+ " Not Found" );
           }
            return st;
        }
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
	   //repo.removeById(id);
	return new ResponseEntity<>("Your message here", HttpStatus.OK);
	    }
	*/
	
	@RequestMapping(value = "/api/getCachingData/{sid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Workers getCachingStudents(@PathVariable(value = "sid") String sid) {
		System.out.println("Inside json controller"+sid);
		return cs.createWorkers(sid);
	    
		/*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           return session.createQuery("from Student", Student.class).list();
        }*/
	}
	
	@RequestMapping(value = "/api/getDatabaseCaching/{sid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> getStudentsbyCaching(@PathVariable(value = "sid") Integer sid) {
	    
		
            return cs.getDatabaseCaching(sid);
        }
	
	


}

//Query q = getSession().createQuery("select u from User u where u.company.id = :id");
//q.setParameter("id", id);
//List<User> list = q.list();
