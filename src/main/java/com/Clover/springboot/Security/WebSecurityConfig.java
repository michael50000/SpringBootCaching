package com.Clover.springboot.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

import com.Clover.springboot.SecurityHandler.StudentAuthenticationHandler;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
	@Autowired
	private StudentAuthenticationHandler successHandler;
	@Value("${ldap.urls}")
	private String ldapUrls;
	@Value("${ldap.base.dn}")
	private String ldapBaseDn;
	@Value("${ldap.username}")
	private String ldapSecurityPrincipal;
	@Value("${ldap.password}")
	private String ldapPrincipalPassword;
	@Value("${ldap.user.dn.pattern}")
	private String ldapUserDnPattern;
	@Value("${ldap.enabled}")
	private String ldapEnabled;
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.antMatcher("/**")
             .authorizeRequests()
             
             .antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
				.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN").antMatchers("/addNewEmployee")
				.hasAnyRole("ADMIN").anyRequest().authenticated()
				.and().formLogin().successHandler(successHandler)
             
             
             .antMatchers( "/login**", "/error**")
            .permitAll().and()
             .authorizeRequests()
             .anyRequest().authenticated()
         .and()
         .formLogin().permitAll();
		 http.csrf().disable();
	
			
		

	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers("/viewStudents").hasAnyRole("USER", "ADMIN")
				
				.antMatchers("/addForm").hasAnyRole("ADMIN").anyRequest().authenticated()
				.and().formLogin().successHandler(successHandler).permitAll().and().logout().permitAll();

		http.csrf().disable();
		/*.authorizeRequests()
        .requestMatchers(EndpointRequest.to("/health", "/flyway","/info","/beans")).permitAll()
        .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")*/
		http.httpBasic();
		http.authorizeRequests()
        .antMatchers("/actuator/**").hasRole("ACTUATOR")
        .anyRequest().permitAll();
		
		
		//http.requiresChannel().antMatchers("/viewStudents","/addForm").requiresSecure();
	}

	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("user").password(passwordEncoder().encode("user")).roles("USER").and()
            .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
            
    }
	@Bean
    public BCryptPasswordEncoder passwordEncoder(){ 
        return new BCryptPasswordEncoder(); 
    }
	
	

}