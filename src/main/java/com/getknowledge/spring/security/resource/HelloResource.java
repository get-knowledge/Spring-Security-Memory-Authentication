package com.getknowledge.spring.security.resource;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/hello")
public class HelloResource {
	
	@GetMapping
	public String hello( @AuthenticationPrincipal final UserDetails userDetails) {
		
	String userNme	= userDetails.getUsername();
	Collection<? extends GrantedAuthority> authorities =userDetails.getAuthorities();
		authorities.stream()
		.forEach(authority->System.out.println(authority));
	
		return "Hello Demo";
	}

}
