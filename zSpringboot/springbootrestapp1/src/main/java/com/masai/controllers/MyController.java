package com.masai.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
  
	
	@RequestMapping("/string")
	public String getStr() {
		return "i am in spring boot application====================";
	}
	
	
}
