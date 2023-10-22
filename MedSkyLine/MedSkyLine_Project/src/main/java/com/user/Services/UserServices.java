package com.user.Services;

import com.user.Entities.User;
import com.user.Enums.UserType;
import com.user.Exceptions.UserAlreadyExist;

import java.util.*;


public interface UserServices {
	
	public List<User> listOfLimitedAgeGroupUser=new ArrayList<>();
	
	public List<User> listOfFilterUser=new ArrayList<>();
	
	public User createUser(User user) throws UserAlreadyExist;
	
	public User updateUser(Long userId, User user);
	
	public String deleteUser(Long id);
	
	public List<User> getAllUser();
	
	public List<User> getUserByAge(Integer minAge, Integer maxAge);
	
	public List<User> getAllUserByUserType(UserType type);
	
	
	

}
