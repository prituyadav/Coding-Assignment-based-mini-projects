package com.user.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.Entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	public User findByEmail(String email);
	
	public User findByMobileNo(String mobileNum);
	
	
}
