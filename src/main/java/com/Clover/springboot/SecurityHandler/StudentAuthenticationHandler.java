package com.Clover.springboot.SecurityHandler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class StudentAuthenticationHandler implements AuthenticationSuccessHandler  {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		 boolean hasuser=false;
		 boolean hasadmin=false;
		
		 
		//Collection<? extends GrantedAuthority>authorities= auth.getAuthorities();
        for(GrantedAuthority gh:auth.getAuthorities()){
        	logger.info("Autorities"+gh.getAuthority());
	    if(gh.getAuthority().equals("ROLE_USER")){
		hasuser=true;
		break;
	      }
	    else if(gh.getAuthority().equals("ROLE_ADMIN")){
		hasadmin=true;
		break;
	   }
	   
	}
    if(hasuser){
	redirectStrategy.sendRedirect(req, res, "/viewStudents");
   }else if(hasadmin){
	redirectStrategy.sendRedirect(req, res, "/addForm");
   }else{
	throw new IllegalStateException();
   }


	
	
	
	}}


