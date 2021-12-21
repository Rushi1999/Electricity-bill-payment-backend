package com.cg.spring.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.exception.DuplicateUserException;
import com.cg.spring.boot.demo.exception.InvalidLoginCredentialException;
import com.cg.spring.boot.demo.exception.NoSuchUserException;
import com.cg.spring.boot.demo.model.User;
import com.cg.spring.boot.demo.service.UserServiceImpl;

/*
 * A convenience annotation that is itself annotated with @Controller and @ResponseBody. 
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
/*
 * Marks a constructor, field, setter method, or config method as to be automatically
 * bySpring's dependency injection facilities.
 */
	@Autowired
	private UserServiceImpl userService;

	// http://localhost:8082/register
		@PostMapping("/register")
		public ResponseEntity<User> register(@RequestBody User appUser) throws DuplicateUserException {
			LOG.info("register " + appUser.toString());
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "User registered successfully.");
			return new ResponseEntity<User>(userService.registerUser(appUser), headers, HttpStatus.CREATED);
		}

		// http://localhost:8082/login
		@PostMapping("/login")
		public ResponseEntity<User> login(@RequestBody User appUser) throws InvalidLoginCredentialException {
			LOG.info("login " + appUser.toString());
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "User logged in successfully.");
			return new ResponseEntity<User>(userService.loginUser(appUser), headers, HttpStatus.OK);
		}

		// http://localhost:8082/logout
		@PostMapping("/logout")
		public ResponseEntity<String> logout(@RequestBody String userName) throws NoSuchUserException {
			LOG.info("Controller logout");
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "User logged out successfully.");
			return new ResponseEntity<String>(userService.logout(userName), headers, HttpStatus.OK);
		}
		
	@PutMapping("/changepassword")
	public ResponseEntity<User> changepassword(@RequestBody User changepassword)
			throws InvalidLoginCredentialException {
		LOG.info("Controller updateEmp");
		User emp = userService.changePassword(changepassword);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is updated to DataBase.");
		LOG.info(headers.toString());
		ResponseEntity<User> response = new ResponseEntity<User>(emp, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getuserbyusername/{userName}")
	public ResponseEntity<User> getUserByUserName(@PathVariable(name = "userName") String userName)
			throws NoSuchUserException {
		LOG.info("getEmpByUser");
		User user = userService.searchUserByUserName(userName);
		LOG.info(user.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This User is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<User> response = new ResponseEntity<User>(user, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getuserbyid/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "userid") long id) throws NoSuchUserException {
		LOG.info("getEmpById");
		User user = userService.searchUserByUserId(id);
		LOG.info(user.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This User is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<User> response = new ResponseEntity<User>(user, headers, HttpStatus.OK);
		return response;
	}

	
	
	
}
