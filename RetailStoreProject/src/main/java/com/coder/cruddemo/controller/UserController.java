package com.coder.cruddemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.cruddemo.entity.User;
import com.coder.cruddemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		log.info("Inside addUser");
		User addedUser = userService.addUser(user);
		return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
	}

	@GetMapping("/fetchbyid/{userId}")
	public ResponseEntity<User> fetchUserDetails(@PathVariable("userId") long userIdL) {
		log.info("Inside fetchUserDetails");
		User user = userService.findUserById(userIdL);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
