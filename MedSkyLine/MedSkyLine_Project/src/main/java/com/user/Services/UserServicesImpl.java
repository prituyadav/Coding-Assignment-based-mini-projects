package com.user.Services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Entities.User;
import com.user.Enums.UserType;
import com.user.Exceptions.UserAlreadyExist;
import com.user.Repositories.UserRepository;


@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user)throws UserAlreadyExist{
		User emailUsed=userRepo.findByEmail(user.getEmail());
		User mobNumUsed=userRepo.findByMobileNo(user.getMobileNo());
		
		if(emailUsed!=null || mobNumUsed!=null) {
			throw new UserAlreadyExist ("User has been already resister with this MoblieNumber/Email; Please fill a valid info");
		}
		
		User userr=userRepo.save(user);
		
		
		
		return userr;
	}

	@Override
	public User updateUser(Long userId, User user) {
		User us= userRepo.findById(userId).get();
		us.setName(user.getName());
		us.setDateOfBirth(user.getDateOfBirth());
		us.setMobileNo(user.getMobileNo());
		us.setEmail(user.getEmail());
		us.setUserType(user.getUserType());
		
		return us;
		
	}

	@Override
	public String deleteUser(Long id) {

		userRepo.deleteById(id);
		
	    return "User has been deleted successfully!";
	}

	@Override
	public List<User> getAllUser() {
		List<User> listOfUser=userRepo.findAll();
		return listOfUser;
	}

	
	
	@Override
	public List<User> getUserByAge(Integer minAge,Integer maxAge) {
		List<User> listOfUser=userRepo.findAll();
		
		
		LocalDate currentDate = LocalDate.now();
		
				
		for(int i=0; i<listOfUser.size(); i++) {
			
			int age=(int) ChronoUnit.YEARS.between(listOfUser.get(i).getDateOfBirth(), currentDate);
			
			if(age>=minAge && age<=maxAge) {
				listOfLimitedAgeGroupUser.add(listOfUser.get(i));
			}
			
		}
		return listOfLimitedAgeGroupUser;
		
	}

	@Override
	public List<User> getAllUserByUserType(UserType uType) {
		List<User> listOfUser=userRepo.findAll();
		
		List<User> filteredUsers = listOfUser.stream()
	            .filter(user -> user.getUserType()== uType)
	            .collect(Collectors.toList());
          
		return filteredUsers;
		
	}

}
