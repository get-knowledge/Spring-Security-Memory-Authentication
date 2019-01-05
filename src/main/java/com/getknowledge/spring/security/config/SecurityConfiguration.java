package com.getknowledge.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("dhananjay").password("{noop}1234").roles("USER")
		.and().withUser("manoj").password("{noop}123").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
		.authorizeRequests()
		.antMatchers("**/hello").hasRole("USER")
		//.antMatchers("**/rest/**")
		.anyRequest()
		//.permitAll() 
		.fullyAuthenticated()
		.and().httpBasic();
		httpSecurity.csrf().disable();
		
	}

}
