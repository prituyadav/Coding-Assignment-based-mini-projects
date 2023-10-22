package com.user.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.Entities.User;
import com.user.Enums.UserType;
import com.user.Exceptions.UserAlreadyExist;
import com.user.Services.UserServicesImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserServicesImpl userS;
	
	@PostMapping("/saveUser")
	ResponseEntity<User> addUserHandler(@Valid @RequestBody User user)throws UserAlreadyExist{
		User userr=userS.createUser(user);
		
		return new ResponseEntity<User>(userr,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	ResponseEntity<String> deleteUserHandler(@PathVariable Long id){
		String st=userS.deleteUser(id);
		return new ResponseEntity<String>(st, HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllUsers")
	ResponseEntity<List<User>> getAllUserHandler(){
		List<User> allUsers=userS.getAllUser();
		
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
		
	}
	
	@GetMapping("/getUserByAge/{min}/{max}")
	ResponseEntity<List<User>> getUserByAgeGroupHandler(@PathVariable Integer min, @PathVariable Integer max){
		List<User> allUsers=userS.getUserByAge(min,max);
		
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
		
	}
	
	@GetMapping("/getUserByUserType/{type}")
	ResponseEntity<List<User>> getUserByAgeGroupHandler(@PathVariable UserType type){
		List<User> allUsers=userS.getAllUserByUserType(type);
		
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/updateUserDetails/{id}")
	ResponseEntity<User> updateUserDetails(@PathVariable Long id, @RequestBody User user){
		User us=userS.updateUser(id, user);
		
		return new ResponseEntity<User>(us,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
}
