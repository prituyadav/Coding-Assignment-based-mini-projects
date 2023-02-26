package com.masai.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.dto.UserDto;
import com.masai.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	void save(UserDto user);
	

}
