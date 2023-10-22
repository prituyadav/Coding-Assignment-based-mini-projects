package com.pharma.EmpController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.Entity.Employee;
import com.pharma.Services.Services;

@RestController
public class Controller {
	
	@Autowired
	Services s;

	@GetMapping("/get")
	ResponseEntity<String> getResponse(){
		return new ResponseEntity<>("Getting...", HttpStatus.OK);
	}
	
	@PostMapping("/save")
	ResponseEntity<Employee> addEmployeeHandler(@RequestBody Employee emp){
		Employee st=s.createE(emp);
		return new ResponseEntity<Employee>(st, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	ResponseEntity<Employee> updateEmp(@RequestBody Employee em){
		Employee emp=s.update(em);

	return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
	}
		
	@DeleteMapping("/delete/{id}")
	ResponseEntity<String> delete(@PathVariable Integer id){
		String st=s.removed(id);
		return new ResponseEntity<String>(st, HttpStatus.OK);
	}
		
	@GetMapping("/getEmp/{id}")
	ResponseEntity<Employee> getEmp(@PathVariable Integer id){
		Employee em=s.get(id);
		
		return new ResponseEntity<Employee>(em, HttpStatus.OK);
	}
	
	
}
