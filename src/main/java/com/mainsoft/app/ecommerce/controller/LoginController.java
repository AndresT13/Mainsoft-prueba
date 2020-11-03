package com.mainsoft.app.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/")
	public ResponseEntity<?> login() {		
		 
		return new ResponseEntity( "prueba", HttpStatus.OK);
	}
	
	
	
}
