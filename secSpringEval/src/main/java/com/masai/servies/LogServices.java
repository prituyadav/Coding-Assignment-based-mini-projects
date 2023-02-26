package com.masai.servies;

import org.apache.logging.log4j.LoggingException;

import com.masai.dto.LogDto;
;

public interface LogServices {

	public String logIntoAccount(LogDto dto)throws LoggingException;

	public String logOutFromAccount(String key)throws LoggingException;
}
