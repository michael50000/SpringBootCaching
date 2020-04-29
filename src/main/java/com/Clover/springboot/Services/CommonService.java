package com.Clover.springboot.Services;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.springframework.stereotype.Component;

import com.Clover.springboot.HibernateUtil.HibernateUtil;
import com.Clover.springboot.Model.Student;
import com.Clover.springboot.Model.Tasks;

@Component
public class CommonService {
	
	 public List < Student > getStudents() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Student", Student.class).list();
	        }
	    }
	 
	 public int  insertStudents() {
		    Transaction transaction = null;
		    int i = 0;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            
	            Tasks t=new Tasks();
	            t.setTitle("Harry");
	            t.setDescription("Potter");
	             i=  (int) session.save(t);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            } 
	            e.printStackTrace();
	        }
			return i;
		
	    }
	
	 public int delete(int task_id){
		 int result=0;
		 Transaction transaction = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			 transaction = session.getTransaction();
	         transaction.begin();
	         Tasks t=session.get(Tasks.class, task_id);
	         if(t!=null){
	            session.delete(t);
	            System.out.println(" deleted");
	            transaction.commit();
	         }
	            return result;
		 }
	            
		
		 
	 }
		 
		 
		 public String deleteStudent(int sid){
			
			 String status="P";
			 Transaction transaction = null;
			 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				
				 transaction = session.getTransaction();
		         transaction.begin();
		         Student t=session.get(Student.class, sid);
		         if(t!=null){
		            session.delete(t);
		            System.out.println(" deleted");
		            transaction.commit();
		            status="S";
		         }
		            return status;
		            
			
			 
		 }
   }
	 
	 
	 public String insertStudentData(String name,String email,String dept){
		 Transaction transaction = null;
		    int i = 0;
		    String status = null;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            Student st=new Student();
	            st.setName(name);
	            st.setEmail(email);
	            st.setDept(dept);
	           
	             i=  (int) session.save(st);
	             if(i>0){
	            	 status="Inserted Sucessfully";
	             }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            } 
	            e.printStackTrace();
	            status= e.getMessage();
	        }
			return status;
		 
	 }
	 
	 public String updateStudent(int sid,String name,String email,String dept){
		 String s="P";
		 Transaction transaction = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 /*Query query = session.createQuery("update Student set name = :name ,email=:email,dept=:dept "        +
	    				" where sid = :sid");
	              query.setParameter("sid", sid);
	              query.setParameter("name", name);
	              query.setParameter("dept", dept);
	              int result = query.executeUpdate();*/
			 
			    transaction = session.beginTransaction();
	            // save the student object
	            Student st=new Student();
	            st.setSid(sid);
	            st.setName(name);
	            st.setEmail(email);
	            st.setDept(dept);
	            session.update(st);
	            
	            transaction.commit();
	            s="S";
	             
			  
		 }catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            } 
	            e.printStackTrace();
	            s= e.getMessage();
	        }
		 
		return s;
		 
	 }
}
	 

	 
	 
	 


