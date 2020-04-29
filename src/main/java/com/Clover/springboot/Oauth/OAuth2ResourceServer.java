//package com.Clover.springboot.Oauth;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {
//	
//	@Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//            .antMatchers("/api/**").authenticated()
//            .antMatchers("/").permitAll();
//    }
//	
//	
//
//}
