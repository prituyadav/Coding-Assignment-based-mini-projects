package com.masai.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends Exception {
	
	String er;
  public UserNotFoundException(String err) {
	super(err);
	this.er=err;
  }
}
