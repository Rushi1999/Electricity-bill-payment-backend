package com.cg.spring.boot.demo.service;

import com.cg.spring.boot.demo.exception.DuplicateUserException;
import com.cg.spring.boot.demo.exception.InvalidLoginCredentialException;
import com.cg.spring.boot.demo.exception.NoSuchUserException;
import com.cg.spring.boot.demo.model.User;

public interface UserService {
	public User registerUser(User user) throws DuplicateUserException;
	public User loginUser(User user) throws InvalidLoginCredentialException;
	public String logout(String userName) throws NoSuchUserException;
	public User changePassword(User user) throws InvalidLoginCredentialException;
//	public void forgotPassword(String userName);
	public User searchUserByUserName(String userName)throws NoSuchUserException;
	public User searchUserByUserId(long userId)throws NoSuchUserException;
	


}
