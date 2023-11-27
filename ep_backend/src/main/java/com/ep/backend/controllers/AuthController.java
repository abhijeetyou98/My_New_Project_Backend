package com.ep.backend.controllers;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ep.backend.dto.StudentDto;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	 @Autowired
    private UserDetailsService userDetailsService;
	 
	 @Autowired
	 private ModelMapper mapper;
	 
	 private Logger logger = LoggerFactory.getLogger(AuthController.class);
	
//	this will show whch user is logged in
	@GetMapping("/current")
	public ResponseEntity<StudentDto> getCurrentUser(Principal principal){
		String name = principal.getName();		
		return new ResponseEntity<>(mapper.map(userDetailsService.loadUserByUsername(name), StudentDto.class), HttpStatus.OK);
    }

}
