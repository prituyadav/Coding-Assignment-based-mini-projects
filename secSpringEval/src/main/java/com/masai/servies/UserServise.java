package com.masai.servies;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import com.masai.dto.UserDto;
import com.masai.exceptions.UserNotFoundException;

public interface UserServise {
   UserDto createUser(UserDto user) ;
   UserDto updateUser(UserDto user, Integer userid);
}
