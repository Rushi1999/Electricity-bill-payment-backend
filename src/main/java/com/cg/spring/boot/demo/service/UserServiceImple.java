package com.cg.spring.boot.demo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.DuplicateUserException;
import com.cg.spring.boot.demo.exception.InvalidLoginCredentialException;
import com.cg.spring.boot.demo.exception.NoSuchUserException;
import com.cg.spring.boot.demo.model.User;
import com.cg.spring.boot.demo.repository.UserRepository;

@Service
public class UserServiceImple implements UserService {

	public boolean isLoggedIn;

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImple.class);

	@Autowired
	private UserRepository userRepository;

	private User tempUser;

	public User registerUser(User user) throws DuplicateUserException {	
		LOG.info("register");
		if (userRepository.findByUserName(user.getUserName())!=null)
		{	throw new DuplicateUserException("This user is already register");
		
		}
		else
		{
		return userRepository.save(user);
		}
	}


	@Override
	public User loginUser(User user) throws InvalidLoginCredentialException {
		LOG.info("login");
		tempUser = userRepository.findByUserName(user.getUserName());
		if (tempUser.getUserName().equalsIgnoreCase(user.getUserName())) {
			isLoggedIn = true;
			return tempUser;
		}
		throw new InvalidLoginCredentialException("invalid user or password");
	}
	
	@Override
	public String logout(String userName) throws NoSuchUserException {
		LOG.info("logout");
		if (isLoggedIn) {
			isLoggedIn = false;
			return "User logged out successfully.";
		}
		throw new NoSuchUserException(userName+" this user is not present");
	}
	
	@Override
	public User changePassword(User user) throws InvalidLoginCredentialException {
		LOG.info("change your password");
		if (userRepository.existsById(user.getUserId())) {
			return userRepository.save(user);
		}
		LOG.info(user.getUserId() + " does not exist.");
		throw new InvalidLoginCredentialException(" this user is not present or invalid credebtial");
	}

//	@Override
//	public void forgotPassword(String userName) {
//
//	}

	@Override
	public User searchUserByUserName(String userName) throws NoSuchUserException {
		LOG.info("get User By UserName");
		tempUser=userRepository.findByUserName(userName);
		if (tempUser.getUserName().equals(userName)) {
			LOG.info("User is available.");
			return tempUser;
		} else {
			LOG.info("User is NOT available.");
			throw new NoSuchUserException(userName + " this user is not found.");
		}
	}

	@Override
	public User searchUserByUserId(long userId) throws NoSuchUserException {
		LOG.info("get User By Id");
		Optional<User> Opt = userRepository.findById(userId);
		if (Opt.isPresent()) {
			LOG.info("User is available.");
			return Opt.get();
		} else {
			LOG.info("User is NOT available.");
			throw new NoSuchUserException(userId + " this user is not found.");
		}
	}

}
