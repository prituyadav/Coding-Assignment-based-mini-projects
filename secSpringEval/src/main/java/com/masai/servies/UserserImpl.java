package com.masai.servies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.UserDto;
import com.masai.entity.User;
import com.masai.repos.UserRepo;
import com.masai.exceptions.UserNotFoundException;
import jakarta.persistence.Access;

@Service
public class UserserImpl implements UserServise{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userdto) {
		
		User user=this.dtoToUser(userdto);
		User saveduser=this.userRepo.save(user);
		
		return this.userToDto(saveduser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userid) {
		
		try {
			Optional<User> user=Optional.of(this.userRepo.findById(userid).orElseThrow(()->new UserNotFoundException("not found")));
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userdto;
	   
	}
	
     private User dtoToUser(UserDto userDto) {
    	 User user=new User();
    	 user.setId(userDto.getId());
    	 user.setName(userDto.getName());
    	 user.setPassword(userDto.getPassword());
    	 user.setMail(userDto.getMail());
    	 
    	 return user;
     }
     
     private UserDto userToDto(User user) {
    	 UserDto userDto=new UserDto();
    	 userDto.setId(user.getId());
    	 userDto.setName(user.getName());
    	 userDto.setPassword(user.getPassword());
    	 userDto.setMail(user.getMail());
    	 
    	 return userDto;
     }
     
     
     

}
