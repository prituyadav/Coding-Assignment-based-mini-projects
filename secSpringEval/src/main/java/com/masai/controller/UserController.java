package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.UserDto;
import com.masai.servies.UserServise;

@RestController
public class UserController {
	
	@Autowired
	private UserServise userService;
	
	
   @PostMapping("/save")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto){
		UserDto createUsedto=this.userService.createUser(userdto);
		return new ResponseEntity<>(createUsedto, HttpStatus.CREATED);
	}
	

}
